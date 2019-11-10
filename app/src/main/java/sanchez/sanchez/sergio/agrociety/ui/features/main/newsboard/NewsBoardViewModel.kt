package sanchez.sanchez.sergio.agrociety.ui.features.main.newsboard

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Publication
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class NewsBoardViewModel @Inject constructor(): SupportLCEViewModel<Publication, Void>() {

    private val publications = arrayListOf(
        Publication(
            image = R.drawable.publication_example_one,
            title = "First Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        ),
        Publication(
            image = R.drawable.publication_example_two,
            title = "Second Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        ),
        Publication(
            image = R.drawable.publication_example_tree,
            title = "Third Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        ),
        Publication(
            image = R.drawable.publication_example_four,
            title = "Four Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        ),
        Publication(
            image = R.drawable.publication_example_one,
            title = "Five Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        ),
        Publication(
            image = R.drawable.publication_example_two,
            title = "Six Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        ),
        Publication(
            image = R.drawable.publication_example_tree,
            title = "Seven Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        ),
        Publication(
            image = R.drawable.publication_example_one,
            title = "Eight Publication",
            date = Date(),
            likesCount = 8,
            commentsCount = 5
        )
    )


    override suspend fun onLoadData(): List<Publication> =
        publications


    override suspend fun onLoadData(params: Void): List<Publication> =
        publications
}