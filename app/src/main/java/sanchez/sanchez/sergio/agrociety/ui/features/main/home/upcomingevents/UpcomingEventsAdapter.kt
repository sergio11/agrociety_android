package sanchez.sanchez.sergio.agrociety.ui.features.main.home.upcomingevents

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.extension.toStringFormat
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

class UpcomingEventsAdapter(context: Context, data: MutableList<UpcomingEvent>):
    SupportRecyclerViewAdapter<UpcomingEvent>(context, data) {

    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<UpcomingEvent> =
        PublicationViewHolder(inflater.inflate(
            R.layout.upcoming_event_item_layout, viewGroup, false))


    inner class PublicationViewHolder(itemView: View) : SupportRecyclerViewAdapter<UpcomingEvent>
    .SupportItemViewHolder<UpcomingEvent>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: UpcomingEvent) {
            super.bind(element)

            itemView.apply {
                findViewById<TextView>(R.id.eventTitle).text = element.title
                findViewById<TextView>(R.id.eventDate).text =
                    element.date.toStringFormat(context.getString(R.string.date_format))
            }
        }
    }
}