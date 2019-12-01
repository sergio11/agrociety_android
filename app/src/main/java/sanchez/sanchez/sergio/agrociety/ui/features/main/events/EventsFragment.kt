package sanchez.sanchez.sergio.agrociety.ui.features.main.events

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_events_layout.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.EventsComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment

class EventsFragment : SupportLCEFragment<Void, UpcomingEvent, Void, EventsViewModel>(
    EventsViewModel::class.java) {

    private val component: EventsComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getEventsComponent(activity as SupportActivity)
    }

    private val linearLayoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<UpcomingEvent> =
        EventsAdapter(requireContext(), ArrayList())

    override fun layoutId(): Int = R.layout.fragment_events_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onStart() {
        super.onStart()
        startObserveScrollEvents()
    }

    override fun onStop() {
        super.onStop()
        stopObserveScrollEvents()
    }

    override fun onCreateLayoutManager(): RecyclerView.LayoutManager =
        linearLayoutManager

    override fun onItemClick(item: UpcomingEvent) {}

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}

    /**
     * Private Methods
     */

    private fun startObserveScrollEvents() {
        recyclerView?.addOnScrollListener(object: RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                if(dy > 0) {
                    onScrollDown()
                } else {
                    if(linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0)
                        onTopReached()
                }
            }
        })
    }

    private fun stopObserveScrollEvents() {
        recyclerView?.clearOnScrollListeners()
    }

    private fun onScrollDown(){
        calendarView.collapse()
    }

    private fun onTopReached() {
        calendarView.expand()
    }
}