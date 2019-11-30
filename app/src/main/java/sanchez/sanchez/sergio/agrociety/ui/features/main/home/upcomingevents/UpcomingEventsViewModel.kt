package sanchez.sanchez.sergio.agrociety.ui.features.main.home.upcomingevents

import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class UpcomingEventsViewModel @Inject constructor(): SupportLCEViewModel<UpcomingEvent, Void>() {


    private val upcomingEventList = mutableListOf(
        UpcomingEvent(
            title = "Title 1",
            date = Date()
        ),
        UpcomingEvent(
            title = "Title 2",
            date = Date()
        ),
        UpcomingEvent(
            title = "Title 3",
            date = Date()
        ),
        UpcomingEvent(
            title = "Title 4",
            date = Date()
        )
    )


    override suspend fun onLoadData(): List<UpcomingEvent> =
        upcomingEventList

    override suspend fun onLoadData(params: Void): List<UpcomingEvent> =
        upcomingEventList
}