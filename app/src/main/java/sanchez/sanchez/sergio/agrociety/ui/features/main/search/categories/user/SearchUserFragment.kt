package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.user

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SearchComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.SearchFragmentDirections
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.post.SearchPostFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.tags.SearchCategoryTagsFragment
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportGroupedRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportGroupedLCEFragment
import javax.inject.Inject

class SearchUserFragment: SupportGroupedLCEFragment<Void, User, Void, SearchUserViewModel>(SearchUserViewModel::class.java) {

    private val component: SearchComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSearchComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun onCreateAdapter(): SupportGroupedRecyclerViewAdapter<User> =
        SearchUserAdapter(requireContext(), picasso)

    override fun layoutId(): Int = R.layout.fragment_search_user_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchCategory = requireArguments().getParcelable<SearchCategory>(
            SearchPostFragment.CATEGORY_ARG
        )
            ?: throw IllegalArgumentException("Search Category is required")

        childFragmentManager.beginTransaction()
            .add(R.id.categoryTagsContainer, SearchCategoryTagsFragment.newInstance(searchCategory.id))
            .commit()
    }

    override fun onInject() {
        component.inject(this)
    }

    override fun onItemClick(item: Section<User>) {
        navigate(SearchFragmentDirections.actionGlobalUserDetailFragment(item.element()))
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}

    companion object {

        const val CATEGORY_ARG = "CATEGORY"

        @JvmStatic
        fun newInstance(category: SearchCategory) = SearchUserFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY_ARG, category)
            }
        }
    }
}