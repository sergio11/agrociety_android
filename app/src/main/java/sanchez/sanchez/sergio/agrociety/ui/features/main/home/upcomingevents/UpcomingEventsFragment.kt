package sanchez.sanchez.sergio.agrociety.ui.features.main.home.upcomingevents

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.EventsComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import android.view.MotionEvent



class UpcomingEventsFragment : SupportLCEFragment<Void, UpcomingEvent, Void, UpcomingEventsViewModel>(
    UpcomingEventsViewModel::class.java) {

    private val component: EventsComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getEventsComponent(activity as SupportActivity)
    }

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<UpcomingEvent> =
        UpcomingEventsAdapter(requireContext(), ArrayList())

    override fun layoutId(): Int =
        R.layout.fragment_upcoming_events

    override fun onInject() {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView?.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                when (e.action) {
                    MotionEvent.ACTION_MOVE ->
                        rv.parent.requestDisallowInterceptTouchEvent(true)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        })

    }

    override fun onItemClick(item: UpcomingEvent) {

    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {

    }


}