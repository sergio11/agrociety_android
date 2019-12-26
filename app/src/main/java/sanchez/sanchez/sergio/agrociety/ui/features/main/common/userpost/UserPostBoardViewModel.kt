package sanchez.sanchez.sergio.agrociety.ui.features.main.common.userpost

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class UserPostBoardViewModel @Inject constructor(): SupportLCEViewModel<Post, Void>() {
    private val publications = arrayListOf(
        Post(
            image = R.drawable.publication_example_one,
            title = "First Post",
            subtitle = "First Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "Second Post",
            subtitle = "Second Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_tree,
            title = "Third Post",
            subtitle = "Third Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_four,
            title = "Four Post",
            subtitle = "Four Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_one,
            title = "Five Post",
            subtitle = "Five Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "Six Post",
            subtitle = "Six Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_tree,
            title = "Seven Post",
            subtitle = "Seven Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_one,
            title = "Eight Post",
            subtitle = "Eight Post Subtitle",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsadsadsadas",
                displayName = "David Martín Fidalgo",
                email = "davidmartin@gmail.com",
                followers = 32,
                follow = 23,
                photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
                background = R.drawable.publication_example_one
            )
        )
    )


    override suspend fun onLoadData(): List<Post> =
        publications


    override suspend fun onLoadData(params: Void): List<Post> =
        publications
}