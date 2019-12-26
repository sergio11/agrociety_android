package sanchez.sanchez.sergio.agrociety.ui.features.main.home.lastannouncements

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.LastAnnouncementsComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Announcement
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.HomeFragmentDirections
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment

class LastAnnouncementsFragment: SupportLCEFragment<Void, Announcement, Void, LastAnnouncementsViewModel>(LastAnnouncementsViewModel::class.java) {

    private val component: LastAnnouncementsComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getLastAnnouncementsComponent(activity as SupportActivity)
    }

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager =
        LinearLayoutManager(requireContext(), HORIZONTAL, false)

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Announcement> =
        LastAnnouncementsAdapter(requireContext(), ArrayList())

    override fun layoutId(): Int =
        R.layout.fragment_last_announcements

    override fun onInject() {
        component.inject(this)
    }

    override fun onItemClick(item: Announcement) {}

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
    }
}