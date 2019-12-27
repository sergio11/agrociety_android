package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.post

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SearchComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.SearchFragmentDirections
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.tags.SearchCategoryTagsFragment
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportGroupedRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportGroupedLCEFragment
import javax.inject.Inject

class SearchPostFragment: SupportGroupedLCEFragment<Void, Post, Void, SearchPostViewModel>(SearchPostViewModel::class.java),
    SearchPostAdapter.OnSearchPostListener {

    private val component: SearchComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSearchComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun onCreateAdapter(): SupportGroupedRecyclerViewAdapter<Post> =
        SearchPostAdapter(requireContext(), picasso).also {
            it.listener = this
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchCategory = requireArguments().getParcelable<SearchCategory>(CATEGORY_ARG)
            ?: throw IllegalArgumentException("Search Category is required")

        childFragmentManager.beginTransaction()
            .add(R.id.categoryTagsContainer, SearchCategoryTagsFragment.newInstance(searchCategory.id))
            .commit()

    }

    override fun layoutId(): Int = R.layout.fragment_search_post_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onItemClick(item: Section<Post>) {
        navigate(SearchFragmentDirections.actionGlobalPostDetailFragment(item.element()))
    }

    override fun onGoToUserDetail(user: User) {
        navigate(SearchFragmentDirections.actionGlobalUserDetailFragment(user))
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}


    companion object {

        const val CATEGORY_ARG = "CATEGORY"

        @JvmStatic
        fun newInstance(category: SearchCategory) = SearchPostFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY_ARG, category)
            }
        }
    }

}