package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.announcements

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Announcement
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class SearchAnnouncementsViewModel @Inject constructor(): SupportLCEViewModel<Announcement, Void>() {

    private val announcements = arrayListOf(
        Announcement(
            id = "fdsjfksdfjkuiorew",
            title = "Announcement 1",
            date = Date(),
            imageRes = R.drawable.publication_example_one
        ),
        Announcement(
            id = "4234fdsfdsfds",
            title = "Announcement 2",
            date = Date(),
            imageRes = R.drawable.publication_example_two
        ),
        Announcement(
            id = "vdsfsd545435345",
            title = "Announcement 3",
            date = Date(),
            imageRes = R.drawable.publication_example_tree
        ),
        Announcement(
            id = "fdsfdsfsdf6546456456",
            title = "Announcement 4",
            date = Date(),
            imageRes = R.drawable.publication_example_four
        ),
        Announcement(
            id = "fsdfdsfsdf543534534534",
            title = "Announcement 5",
            date = Date(),
            imageRes = R.drawable.publication_example_one
        ),
        Announcement(
            id = "asdsadsadas543534543",
            title = "Announcement 6",
            date = Date(),
            imageRes = R.drawable.publication_example_two
        ),
        Announcement(
            id = "werweerewr5345345345",
            title = "Announcement 7",
            date = Date(),
            imageRes = R.drawable.publication_example_tree
        ),
        Announcement(
            id = "fdsjfksdfjkuiorew",
            title = "Announcement 8",
            date = Date(),
            imageRes = R.drawable.publication_example_four
        )
    )


    override suspend fun onLoadData(): List<Announcement> =
        announcements

    override suspend fun onLoadData(params: Void): List<Announcement> =
        announcements

}