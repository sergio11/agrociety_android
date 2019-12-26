package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.event

import sanchez.sanchez.sergio.agrociety.domain.model.UpcomingEvent
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportGroupedLCEViewModel
import javax.inject.Inject

class SearchEventViewModel @Inject constructor(): SupportGroupedLCEViewModel<UpcomingEvent, Void>() {
    override fun onCompareElements(elementOne: UpcomingEvent, elementTwo: UpcomingEvent): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCheckIfNextElementIsInSameGroup(
        previousElement: UpcomingEvent,
        nextElement: UpcomingEvent
    ): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateDataSet(params: Void?): List<UpcomingEvent> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}