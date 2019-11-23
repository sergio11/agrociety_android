package sanchez.sanchez.sergio.agrociety.ui.features.main.home.lastannouncements

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Announcement
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class LastAnnouncementsViewModel @Inject constructor(): SupportLCEViewModel<Announcement, Void>() {

    private val lastAnnouncements = arrayListOf(
        Announcement(
            id = "fdsjfksdfjkuiorew",
            title = "Last Announcement 1",
            date = Date(),
            imageRes = R.drawable.publication_example_one
        ),
        Announcement(
            id = "4234fdsfdsfds",
            title = "Last Announcement 2",
            date = Date(),
            imageRes = R.drawable.publication_example_two
        ),
        Announcement(
            id = "vdsfsd545435345",
            title = "Last Announcement 3",
            date = Date(),
            imageRes = R.drawable.publication_example_tree
        ),
        Announcement(
            id = "fdsfdsfsdf6546456456",
            title = "Last Announcement 4",
            date = Date(),
            imageRes = R.drawable.publication_example_four
        ),
        Announcement(
            id = "fsdfdsfsdf543534534534",
            title = "Last Announcement 5",
            date = Date(),
            imageRes = R.drawable.publication_example_one
        ),
        Announcement(
            id = "asdsadsadas543534543",
            title = "Last Announcement 6",
            date = Date(),
            imageRes = R.drawable.publication_example_two
        ),
        Announcement(
            id = "werweerewr5345345345",
            title = "Last Announcement 7",
            date = Date(),
            imageRes = R.drawable.publication_example_tree
        ),
        Announcement(
            id = "fdsjfksdfjkuiorew",
            title = "Last Announcement 8",
            date = Date(),
            imageRes = R.drawable.publication_example_four
        )
    )


    override suspend fun onLoadData(): List<Announcement> =
        lastAnnouncements


    override suspend fun onLoadData(params: Void): List<Announcement> =
        lastAnnouncements
}