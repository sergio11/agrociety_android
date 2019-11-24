package sanchez.sanchez.sergio.agrociety.ui.features.main.contactlist

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportStickyAdapter

class ContactListAdapter(context: Context) : SupportStickyAdapter<User>(context) {

    override fun onBindHeaderViewHolder(
        holder: SupportHeaderViewHolder<Section<User>>,
        headerPosition: Int
    ) {

        holder.bind(getData()[headerPosition])
        Log.d("CONTACT_LIST", "onBindHeaderViewHolder -> header Position : $headerPosition")
    }

    /**
     * On Create Header
     */
    override fun onCreateHeaderItemViewHolder(viewGroup: ViewGroup): SupportHeaderViewHolder<Section<User>> =
        ContactHeaderViewHolder(
            inflater.inflate(
                R.layout.recycler_view_header_item, viewGroup, false)
        )


    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<Section<User>> =
        ContactViewHolder(inflater.inflate(
            R.layout.conversation_item_layout, viewGroup, false))


    /**
     * View Holders
     */
    inner class ContactViewHolder(itemView: View) : SupportRecyclerViewAdapter<Section<User>>
        .SupportItemViewHolder<Section<User>>(itemView) {
        override fun bind(element: Section<User>) {
            super.bind(element)


        }
    }

    inner class ContactHeaderViewHolder(itemView: View) : SupportHeaderViewHolder<Section<User>>(itemView) {
        override fun bind(element: Section<User>) {
            super.bind(element)

            itemView.findViewById<TextView>(R.id.textView)?.text = element.element().displayName.toUpperCase()[0].toString()

        }
    }

}