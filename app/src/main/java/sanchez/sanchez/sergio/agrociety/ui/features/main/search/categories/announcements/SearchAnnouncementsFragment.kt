package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.announcements

import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SearchComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Announcement
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import javax.inject.Inject

class SearchAnnouncementsFragment: SupportLCEFragment<Void, Announcement, Void, SearchAnnouncementsViewModel>(SearchAnnouncementsViewModel::class.java) {


    private val component: SearchComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSearchComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager =
        StaggeredGridLayoutManager(GRID_LAYOUT_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)

    override fun onItemClick(item: Announcement) {}

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Announcement> =
        SearchAnnouncementsAdapter(requireContext(), mutableListOf())

    override fun layoutId(): Int = R.layout.fragment_search_announcements_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}

    companion object {
        const val GRID_LAYOUT_SPAN_COUNT = 2
    }
}