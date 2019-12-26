package sanchez.sanchez.sergio.agrociety.ui.features.main.postdetail.comments

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Comment
import sanchez.sanchez.sergio.brownie.extension.toStringFormat
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

/**
 * Comments Wall Adapter
 * @param context
 * @param data
 */
class CommentsWallAdapter(private val picasso: Picasso, context: Context, data: MutableList<Comment>):
    SupportRecyclerViewAdapter<Comment>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Comment> =
        CommentViewHolder(inflater.inflate(
            R.layout.comment_item_layout, viewGroup, false))


    /**
     * Comment View Holder
     * @param itemView
     */
    inner class CommentViewHolder(itemView: View) : SupportRecyclerViewAdapter<Comment>
    .SupportItemViewHolder<Comment>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: Comment) {
            super.bind(element)

            itemView.apply {
                findViewById<ImageView>(R.id.commentAuthorPhoto)?.let {
                    element.author.photoUrl?.let { photo ->
                        picasso.load(photo)
                            .into(it)
                    } ?: kotlin.run {
                        it.setImageResource(R.drawable.developer_image)
                    }
                }
                findViewById<TextView>(R.id.commentAuthorName)?.let {
                    it.text = element.author.displayName
                }
                findViewById<TextView>(R.id.commentDate)?.let {
                    it.text = element.date.toStringFormat(context.getString(R.string.date_format))
                }
                findViewById<TextView>(R.id.commentText)?.let {
                    it.text = element.text
                }
            }


        }
    }
}