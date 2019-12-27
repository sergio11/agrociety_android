package sanchez.sanchez.sergio.agrociety.ui.features.main.search.tags

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.CategoryTag
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment

class SearchCategoryTagsFragment: SupportLCEFragment<Void, CategoryTag, SearchCategoryTagsArg, SearchCategoryTagsViewModel>(SearchCategoryTagsViewModel::class.java) {

    private val component by lazy {
        DaggerComponentFactory.getSearchComponent(requireActivity() as SupportActivity)
    }

    override fun onGetLoadParams(): SearchCategoryTagsArg? =
        requireArguments().getString(CATEGORY_ID_ARG)?.let {
            SearchCategoryTagsArg(it)
        }

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager =
        LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<CategoryTag> =
        SearchCategoryTagsAdapter(requireContext(), mutableListOf())

    override fun layoutId(): Int = R.layout.fragment_search_category_tags_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onItemClick(item: CategoryTag) {}

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}

    companion object {

        const val CATEGORY_ID_ARG = "CATEGORY_ID"

        @JvmStatic
        fun newInstance(categoryId: String) = SearchCategoryTagsFragment().apply {
            arguments = Bundle().apply {
                putString(CATEGORY_ID_ARG, categoryId)
            }
        }
    }
}