package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.event

import android.content.Context
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportGroupedRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

class SearchEventAdapter(context: Context, private val picasso: Picasso) : SupportGroupedRecyclerViewAdapter<UpcomingEvent>(context) {

    override fun onBindHeaderViewHolder(
        holder: SupportHeaderViewHolder<Section<UpcomingEvent>>,
        headerPosition: Int
    ) {
        holder.bind(getData()[headerPosition])
    }

    /**
     * On Create Header
     */
    override fun onCreateHeaderItemViewHolder(viewGroup: ViewGroup): SupportHeaderViewHolder<Section<UpcomingEvent>> =
        SearchEventHeaderViewHolder(
            inflater.inflate(
                R.layout.contact_header_item, viewGroup, false)
        )


    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Section<UpcomingEvent>> =
        SearchEventViewHolder(inflater.inflate(
            R.layout.contact_item_layout, viewGroup, false))


    /**
     * View Holders
     */
    inner class SearchEventViewHolder(itemView: View) : SupportRecyclerViewAdapter<Section<UpcomingEvent>>
        .SupportItemViewHolder<Section<UpcomingEvent>>(itemView) {

        override fun bind(element: Section<UpcomingEvent>) {
            super.bind(element)

        }
    }

    inner class SearchEventHeaderViewHolder(itemView: View) : SupportHeaderViewHolder<Section<UpcomingEvent>>(itemView) {
        override fun bind(element: Section<UpcomingEvent>) {
            super.bind(element)

        }
    }

}