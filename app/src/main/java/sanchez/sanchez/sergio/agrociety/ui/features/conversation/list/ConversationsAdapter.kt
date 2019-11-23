package sanchez.sanchez.sergio.agrociety.ui.features.conversation.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Conversation
import sanchez.sanchez.sergio.brownie.extension.gone
import sanchez.sanchez.sergio.brownie.extension.toStringFormat
import sanchez.sanchez.sergio.brownie.extension.visible
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter


class ConversationsAdapter(context: Context, data: MutableList<Conversation>):
    SupportRecyclerViewAdapter<Conversation>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Conversation> =
        ConversationViewHolder(inflater.inflate(
            R.layout.conversation_item_layout, viewGroup, false))


    /**
     * Publication View Holder
     * @param itemView
     */
    inner class ConversationViewHolder(itemView: View) : SupportRecyclerViewAdapter<Conversation>
    .SupportItemSwipedViewHolder<Conversation>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: Conversation) {
            super.bind(element)

            itemView.apply {
                findViewById<TextView>(R.id.userName)?.let { textView ->
                    textView.text = element.targetName
                }
                findViewById<TextView>(R.id.lastUpdate)?.let { textView ->
                    textView.text = element.lastUpdate.toStringFormat(
                        context.getString(R.string.date_format)
                    )
                }
                findViewById<TextView>(R.id.lastMessage)?.let {textView ->
                    textView.text  = element.lastMessage
                }
                findViewById<TextView>(R.id.unreadMessagesCount)?.let {textView ->
                    if(element.messageNotReadCount > 0)
                        textView.apply {
                            text = element.messageNotReadCount.toString()
                            visible()
                        }
                    else
                        textView.apply {
                            text = "-"
                            gone()
                        }
                }
            }


        }
    }
}