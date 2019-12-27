package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.user

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportGroupedRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

class SearchUserAdapter(context: Context, private val picasso: Picasso) : SupportGroupedRecyclerViewAdapter<User>(context) {

    override fun onBindHeaderViewHolder(
        holder: SupportHeaderViewHolder<Section<User>>,
        headerPosition: Int
    ) {
        holder.bind(getData()[headerPosition])
    }

    /**
     * On Create Header
     */
    override fun onCreateHeaderItemViewHolder(viewGroup: ViewGroup): SupportHeaderViewHolder<Section<User>> =
        SearchUserHeaderViewHolder(
            inflater.inflate(
                R.layout.search_user_header_item, viewGroup, false)
        )


    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Section<User>> =
        SearchUserViewHolder(inflater.inflate(
            R.layout.search_user_item_layout, viewGroup, false))


    /**
     * View Holders
     */
    inner class SearchUserViewHolder(itemView: View) : SupportRecyclerViewAdapter<Section<User>>
        .SupportItemViewHolder<Section<User>>(itemView) {

        override fun bind(element: Section<User>) {
            super.bind(element)

            itemView.apply {
                findViewById<TextView>(R.id.userName)?.text =
                    element.element().displayName
                findViewById<ImageView>(R.id.userBackgroundImageView)
                    ?.setImageResource(element.element().background)
                element.element().photoUrl?.let { photoUrl ->
                    findViewById<ImageView>(R.id.userImage)?.let {imageViewTarget ->
                        picasso.load(photoUrl).placeholder(R.drawable.developer_image).into(imageViewTarget)
                    }
                }
            }

        }
    }

    inner class SearchUserHeaderViewHolder(itemView: View) : SupportHeaderViewHolder<Section<User>>(itemView) {

        override fun bind(element: Section<User>) {
            super.bind(element)

            itemView.findViewById<TextView>(R.id.textView)?.let {
                it.text = if(element.element().followers >= MIN_FOLLOWERS_COUNT)
                    context.getString(R.string.search_popular_title)
                else
                    context.getString(R.string.search_most_recent_title)
            }
        }
    }

    companion object {

        const val MIN_FOLLOWERS_COUNT = 30
    }

}