package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.post

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.scale
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.extension.getCircularBitmap
import sanchez.sanchez.sergio.brownie.extension.toStringFormat
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportGroupedRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import java.lang.Exception

class SearchPostAdapter(context: Context, private val picasso: Picasso) : SupportGroupedRecyclerViewAdapter<Post>(context) {

    var listener: OnSearchPostListener? = null

    override fun onBindHeaderViewHolder(
        holder: SupportHeaderViewHolder<Section<Post>>,
        headerPosition: Int
    ) {
        holder.bind(getData()[headerPosition])
    }

    /**
     * On Create Header
     */
    override fun onCreateHeaderItemViewHolder(viewGroup: ViewGroup): SupportHeaderViewHolder<Section<Post>> =
        SearchPostHeaderViewHolder(
            inflater.inflate(
                R.layout.search_post_header_item, viewGroup, false)
        )


    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Section<Post>> =
        SearchPostViewHolder(inflater.inflate(
            R.layout.search_post_item_layout, viewGroup, false))


    /**
     * View Holders
     */
    inner class SearchPostViewHolder(itemView: View) : SupportRecyclerViewAdapter<Section<Post>>
        .SupportItemViewHolder<Section<Post>>(itemView) {

        override fun bind(element: Section<Post>) {
            super.bind(element)

            itemView.apply {
                // Configure Card Toolbar
                findViewById<Toolbar>(R.id.cardToolbar)?.apply {
                    title = element.element().author.displayName
                    subtitle = context.getString(R.string.app_name)
                    navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_news)
                    picasso.load(element.element().author.photoUrl).into(object : Target {
                        override fun onPrepareLoad(placeHolderDrawable: Drawable?) { }
                        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                            navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_news)
                        }
                        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
                            bitmap?.let {
                                navigationIcon = BitmapDrawable(resources, it.scale(
                                    width = it.width / 2,
                                    height = it.height / 2).getCircularBitmap())
                            } ?: run {
                                navigationIcon = ContextCompat.getDrawable(context, R.drawable.ic_news)
                            }

                        }
                    })
                    setNavigationOnClickListener {
                        listener?.onGoToUserDetail(element.element().author)
                    }
                    setOnMenuItemClickListener {
                        when(it.itemId) {
                            R.id.userDetail -> {
                                listener?.onGoToUserDetail(element.element().author)
                            }
                        }
                        false
                    }
                }

                // Post Image
                findViewById<ImageView>(R.id.publicationImage)?.setImageResource(element.element().image)
                // Post Title
                findViewById<TextView>(R.id.publicationTitle)?.text = element.element().title
                // Post Date
                findViewById<TextView>(R.id.publicationDate)?.text = element.element().date.toStringFormat(
                    context.getString(R.string.datetime_format)
                )
                // Likes Post
                findViewById<TextView>(R.id.likeCount)?.apply {
                    text = element.element().likesCount.toString()
                    setCompoundDrawablesRelativeWithIntrinsicBounds(
                        R.drawable.ic_like_stroke,
                        0,0,0
                    )
                }
                // Comments Count
                findViewById<TextView>(R.id.commentsCount)?.text = element.element().commentsCount.toString()

            }

        }
    }

    inner class SearchPostHeaderViewHolder(itemView: View) : SupportHeaderViewHolder<Section<Post>>(itemView) {
        override fun bind(element: Section<Post>) {
            super.bind(element)

            itemView.findViewById<TextView>(R.id.textView)?.let {
                it.text = if(element.element().likesCount >= MIN_LIKES_COUNT)
                    context.getString(R.string.search_popular_title)
                else
                    context.getString(R.string.search_most_recent_title)
            }
        }
    }


    interface OnSearchPostListener {
        fun onGoToUserDetail(user: User)

    }

    companion object {

        const val MIN_LIKES_COUNT = 30
    }

}