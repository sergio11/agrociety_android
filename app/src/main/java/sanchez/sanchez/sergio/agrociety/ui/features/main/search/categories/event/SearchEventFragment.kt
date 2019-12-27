package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.event

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SearchComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.announcements.SearchAnnouncementsFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.post.SearchPostFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.tags.SearchCategoryTagsFragment
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import javax.inject.Inject

class SearchEventFragment: SupportLCEFragment<Void, UpcomingEvent, Void, SearchEventViewModel>(SearchEventViewModel::class.java) {

    private val component: SearchComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSearchComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager =
        StaggeredGridLayoutManager(SearchAnnouncementsFragment.GRID_LAYOUT_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<UpcomingEvent> =
        SearchEventAdapter(requireContext(), picasso, mutableListOf())

    override fun onItemClick(item: UpcomingEvent) {}

    override fun layoutId(): Int = R.layout.fragment_search_event_layout

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchCategory = requireArguments().getParcelable<SearchCategory>(SearchPostFragment.CATEGORY_ARG)
            ?: throw IllegalArgumentException("Search Category is required")

        childFragmentManager.beginTransaction()
            .add(R.id.categoryTagsContainer, SearchCategoryTagsFragment.newInstance(searchCategory.id))
            .commit()

    }

    override fun onInject() {
        component.inject(this)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}

    companion object {

        const val GRID_LAYOUT_SPAN_COUNT = 2
        const val CATEGORY_ARG = "CATEGORY"

        @JvmStatic
        fun newInstance(category: SearchCategory) = SearchEventFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY_ARG, category)
            }
        }
    }

}