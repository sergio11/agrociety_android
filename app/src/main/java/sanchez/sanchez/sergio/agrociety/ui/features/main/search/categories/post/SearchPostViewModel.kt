package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.post

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportGroupedLCEViewModel
import java.util.*
import javax.inject.Inject

class SearchPostViewModel @Inject constructor(): SupportGroupedLCEViewModel<Post, Void>() {

    private val publications = arrayListOf(

        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the second post",
            subtitle = "This is the subtitle for the second post",
            date = Date(),
            likesCount = 78,
            commentsCount = 5,
            author = User(
                id = "adsar3werfdsfseewqe",
                displayName = "User 1",
                followers = 12,
                follow = 65,
                email = "user1@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        ),

        Post(
            image = R.drawable.publication_example_four,
            title = "This is the title for the four post",
            subtitle = "This is the subtitle for the four post",
            date = Date(),
            likesCount = 67,
            commentsCount = 5,
            author = User(
                id = "dafdsf789478392hklfhsd",
                displayName = "User 2",
                followers = 12,
                follow = 5,
                email = "user2@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_four
            )
        ),

        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the eight post",
            subtitle = "This is the subtitle for the eight post",
            date = Date(),
            likesCount = 67,
            commentsCount = 5,
            author = User(
                id = "4324324sfgsgfdgfd",
                displayName = "User 3",
                followers = 22,
                follow = 22,
                email = "user3@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_tree
            )
        ),

        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the first post",
            subtitle = "This is the subtitle for the first post",
            date = Date(),
            likesCount = 45,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "User 4",
                email = "user4@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "",
                background = R.drawable.publication_example_one
            )
        ),

        Post(
            image = R.drawable.publication_example_tree,
            title = "This is the title for the seven post",
            subtitle = "This is the subtitle for the seven post",
            date = Date(),
            likesCount = 34,
            commentsCount = 5,
            author = User(
                id = "4324324sfgsgfdgfd",
                displayName = "User 5",
                followers = 22,
                follow = 22,
                email = "user5@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_tree
            )
        ),

        Post(
            image = R.drawable.publication_example_tree,
            title = "This is the title for the third post",
            subtitle = "This is the subtitle for the third post",
            date = Date(),
            likesCount = 23,
            commentsCount = 5,
            author = User(
                id = "dsadsarewrewrewvcxvs",
                displayName = "User 6",
                followers = 23,
                follow = 54,
                email = "user6@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_tree
            )
        ),

        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the five post",
            subtitle = "This is the subtitle for the five post",
            date = Date(),
            likesCount = 12,
            commentsCount = 5,
            author = User(
                id = "dasdsadsa432423bfdgfdg",
                displayName = "User 7",
                email = "user7@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the six post",
            subtitle = "This is the subtitle for the six post",
            date = Date(),
            likesCount = 3,
            commentsCount = 45,
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "User 8",
                followers = 32,
                follow = 23,
                email = "user8@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the seven post",
            subtitle = "This is the subtitle for the seven post",
            date = Date(),
            likesCount = 2,
            commentsCount = 12,
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "User 9",
                followers = 32,
                follow = 23,
                email = "user9@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the eight post",
            subtitle = "This is the subtitle for the eight post",
            date = Date(),
            likesCount = 1,
            commentsCount = 5,
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "User 10",
                followers = 32,
                follow = 23,
                email = "user10@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the nine post",
            subtitle = "This is the subtitle for the nine post",
            date = Date(),
            likesCount = 1,
            commentsCount = 5,
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "User 11",
                followers = 32,
                follow = 23,
                email = "user11@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        )
    )

    override fun onCompareElements(elementOne: Post, elementTwo: Post): Int =
        when {
            elementOne.likesCount > elementTwo.likesCount -> -1
            elementOne.likesCount == elementTwo.likesCount -> 0
            else -> 1
        }

    override fun onCheckIfNextElementIsInSameGroup(
        previousElement: Post,
        nextElement: Post
    ): Boolean =
        previousElement.likesCount >= MIN_LIKES_COUNT &&
                nextElement.likesCount >= MIN_LIKES_COUNT ||
                previousElement.likesCount < MIN_LIKES_COUNT &&
                nextElement.likesCount < MIN_LIKES_COUNT

    /**
     * Create DATA SET
     */
    override fun onCreateDataSet(params: Void?): List<Post> =
        publications


    companion object {

        const val MIN_LIKES_COUNT = 30
    }
}
