package sanchez.sanchez.sergio.agrociety.ui.features.main.common

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Publication
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

/**
 * Common Publication Adapter
 * @param context
 * @param data
 */
class CommonSimplePublicationAdapter(context: Context, data: MutableList<Publication>):
    SupportRecyclerViewAdapter<Publication>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Publication> =
        PublicationViewHolder(inflater.inflate(
            R.layout.publication_simple_item_layout, viewGroup, false))


    /**
     * Publication View Holder
     * @param itemView
     */
    inner class PublicationViewHolder(itemView: View) : SupportRecyclerViewAdapter<Publication>
    .SupportItemViewHolder<Publication>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: Publication) {
            super.bind(element)

            itemView.apply {
                // Publication Image
                findViewById<ImageView>(R.id.publicationImage)?.setImageResource(element.image)
            }

        }
    }
}