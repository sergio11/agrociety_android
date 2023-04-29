package sanchez.sanchez.sergio.agrociety.ui.features.main.home.newsboard

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class NewsBoardViewModel @Inject constructor(): SupportLCEViewModel<Post, Void>() {

    private val publications = arrayListOf(
        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the first post",
            subtitle = "This is the subtitle for the first post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "User 1",
                email = "user1@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the second post",
            subtitle = "This is the subtitle for the second post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "adsar3werfdsfseewqe",
                displayName = "User 2",
                followers = 12,
                follow = 65,
                email = "user2@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        ),
        Post(
            image = R.drawable.publication_example_tree,
            title = "This is the title for the third post",
            subtitle = "This is the subtitle for the third post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsarewrewrewvcxvs",
                displayName = "User 3",
                followers = 23,
                follow = 54,
                email = "user3@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_tree
            )
        ),
        Post(
            image = R.drawable.publication_example_four,
            title = "This is the title for the four post",
            subtitle = "This is the subtitle for the four post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dafdsf789478392hklfhsd",
                displayName = "User 4",
                followers = 12,
                follow = 5,
                email = "user4@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_four
            )
        ),
        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the five post",
            subtitle = "This is the subtitle for the five post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dasdsadsa432423bfdgfdg",
                displayName = "User 5",
                email = "user5@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the six post",
            subtitle = "This is the subtitle for the six post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "User 6",
                followers = 32,
                follow = 23,
                email = "user6@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        ),
        Post(
            image = R.drawable.publication_example_tree,
            title = "This is the title for the seven post",
            subtitle = "This is the subtitle for the seven post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "4324324sfgsgfdgfd",
                displayName = "User 7",
                followers = 22,
                follow = 22,
                email = "user7@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_tree
            )
        ),
        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the eight post",
            subtitle = "This is the subtitle for the eight post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "4324324sfgsgfdgfd",
                displayName = "User 8",
                followers = 22,
                follow = 22,
                email = "gemajimenezfernandez@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_tree
            )
        )
    )


    override suspend fun onLoadData(): List<Post> =
        publications


    override suspend fun onLoadData(params: Void): List<Post> =
        publications
}
