package sanchez.sanchez.sergio.agrociety.ui.features.main.events

import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class EventsViewModel @Inject constructor(): SupportLCEViewModel<UpcomingEvent, Void>() {

    private val eventsList = mutableListOf(
        UpcomingEvent(
            title = "Event 1",
            date = Date()
        ),
        UpcomingEvent(
            title = "Event 2",
            date = Date()
        ),
        UpcomingEvent(
            title = "Event 3",
            date = Date()
        ),
        UpcomingEvent(
            title = "Event 4",
            date = Date()
        )
    )


    override suspend fun onLoadData(): List<UpcomingEvent> =
        eventsList

    override suspend fun onLoadData(params: Void): List<UpcomingEvent> =
        eventsList
}