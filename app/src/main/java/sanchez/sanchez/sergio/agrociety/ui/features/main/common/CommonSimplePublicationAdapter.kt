package sanchez.sanchez.sergio.agrociety.ui.features.main.common

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

/**
 * Common Post Adapter
 * @param context
 * @param data
 */
class CommonSimplePublicationAdapter(context: Context, data: MutableList<Post>):
    SupportRecyclerViewAdapter<Post>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Post> =
        PublicationViewHolder(inflater.inflate(
            R.layout.publication_simple_item_layout, viewGroup, false))


    /**
     * Post View Holder
     * @param itemView
     */
    inner class PublicationViewHolder(itemView: View) : SupportRecyclerViewAdapter<Post>
    .SupportItemViewHolder<Post>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: Post) {
            super.bind(element)

            itemView.apply {
                // Post Image
                findViewById<ImageView>(R.id.publicationImage)?.setImageResource(element.image)
            }

        }
    }
}