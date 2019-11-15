package sanchez.sanchez.sergio.agrociety.ui.features.main.home.newsboard

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Publication
import sanchez.sanchez.sergio.brownie.extension.toStringFormat
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import timber.log.Timber

/**
 * News Board Adapter
 * @param context
 * @param data
 */
class NewsBoardAdapter(context: Context, data: MutableList<Publication>):
    SupportRecyclerViewAdapter<Publication>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Publication> =
        PublicationViewHolder(inflater.inflate(
            R.layout.publication_item_layout, viewGroup, false))


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

                // Publication Image
                findViewById<ImageView>(R.id.publicationImage)?.setImageResource(element.image)
                // Publication Title
                findViewById<TextView>(R.id.publicationTitle)?.text = element.title
                // Publication Date
                findViewById<TextView>(R.id.publicationDate)?.text = element.date.toStringFormat(
                    context.getString(R.string.datetime_format)
                )
                // Likes Publication
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