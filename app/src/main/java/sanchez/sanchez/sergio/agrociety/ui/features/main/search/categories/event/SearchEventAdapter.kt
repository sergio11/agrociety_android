package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.event

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import java.text.SimpleDateFormat

class SearchEventAdapter(context: Context, private val picasso: Picasso, data: MutableList<UpcomingEvent>) :
    SupportRecyclerViewAdapter<UpcomingEvent>(context, data) {


    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<UpcomingEvent> =
        UpcomingEventViewHolder(inflater.inflate(
            R.layout.search_upcoming_event_item_layout, viewGroup, false))

    /**
     * Announcement View Holder
     * @param itemView
     */
    inner class UpcomingEventViewHolder(itemView: View) : SupportRecyclerViewAdapter<UpcomingEvent>
    .SupportItemViewHolder<UpcomingEvent>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: UpcomingEvent) {
            super.bind(element)

            itemView.apply {
                findViewById<TextView>(R.id.eventTitle).text = element.title
                findViewById<TextView>(R.id.eventDate).text =
                    SimpleDateFormat.getInstance().format(element.date)
            }
        }
    }

}