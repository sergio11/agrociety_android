package sanchez.sanchez.sergio.agrociety.ui.features.main.home.lastannouncements

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Announcement
import sanchez.sanchez.sergio.brownie.extension.toStringFormat
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

class LastAnnouncementsAdapter(context: Context, data: MutableList<Announcement>):
    SupportRecyclerViewAdapter<Announcement>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Announcement> =
        AnnouncementViewHolder(inflater.inflate(
            R.layout.last_announcements_item_layout, viewGroup, false))

    /**
     * Announcement View Holder
     * @param itemView
     */
    inner class AnnouncementViewHolder(itemView: View) : SupportRecyclerViewAdapter<Announcement>
    .SupportItemViewHolder<Announcement>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: Announcement) {
            super.bind(element)

            itemView.apply {
                findViewById<TextView>(R.id.announcementDate).text =
                    element.date.toStringFormat(context.getString(R.string.date_format))
                findViewById<TextView>(R.id.announcementTitle).text =
                    element.title
                findViewById<ImageView>(R.id.announcementImage).setImageResource(
                    element.imageRes
                )
            }
        }
    }
}