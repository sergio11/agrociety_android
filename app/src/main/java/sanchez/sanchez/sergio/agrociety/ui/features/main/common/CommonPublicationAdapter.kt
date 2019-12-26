package sanchez.sanchez.sergio.agrociety.ui.features.main.common

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.brownie.extension.toStringFormat
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import timber.log.Timber

/**
 * Common Post Adapter
 * @param context
 * @param data
 */
class CommonPublicationAdapter(context: Context, data: MutableList<Post>):
    SupportRecyclerViewAdapter<Post>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Post> =
        PublicationViewHolder(inflater.inflate(
            R.layout.publication_item_layout, viewGroup, false))


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
                // Configure Card Toolbar
                findViewById<Toolbar>(R.id.cardToolbar)?.apply {
                    title = context.getString(R.string.app_name)
                    subtitle = context.getString(R.string.app_name)
                    navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_news)
                    setOnMenuItemClickListener {
                        Timber.d("Toolbar Menu Item Clicked")
                        false
                    }
                }

                // Post Image
                findViewById<ImageView>(R.id.publicationImage)?.setImageResource(element.image)
                // Post Title
                findViewById<TextView>(R.id.publicationTitle)?.text = element.title
                // Post Date
                findViewById<TextView>(R.id.publicationDate)?.text = element.date.toStringFormat(
                    context.getString(R.string.datetime_format)
                )
                // Likes Post
                findViewById<TextView>(R.id.likeCount)?.apply {
                    text = element.likesCount.toString()
                    setCompoundDrawablesRelativeWithIntrinsicBounds(
                        R.drawable.ic_like_stroke,
                        0,0,0
                    )
                }
                // Comments Count
                findViewById<TextView>(R.id.commentsCount)?.text = element.commentsCount.toString()

            }

        }
    }
}