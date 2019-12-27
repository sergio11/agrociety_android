package sanchez.sanchez.sergio.agrociety.ui.features.main.search.tags

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.CategoryTag
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter

class SearchCategoryTagsAdapter(context: Context, data: MutableList<CategoryTag>):
    SupportRecyclerViewAdapter<CategoryTag>(context, data) {

    /**
     * On Create Item View Holder
     * @param viewGroup
     */
    override fun onCreateItemViewHolder(viewGroup: ViewGroup): SupportItemViewHolder<CategoryTag> =
        SearchCategoryTagViewHolder(inflater.inflate(
            R.layout.search_category_tag_item_layout, viewGroup, false))

    /**
     * Search Category Tag View Holder
     * @param itemView
     */
    inner class SearchCategoryTagViewHolder(itemView: View) : SupportRecyclerViewAdapter<CategoryTag>
    .SupportItemViewHolder<CategoryTag>(itemView) {

        @SuppressLint("SetTextI18n")
        override fun bind(element: CategoryTag) {
            super.bind(element)

            itemView.apply {
                findViewById<CheckBox>(R.id.tagCheckBox).text = element.name
            }

        }
    }
}