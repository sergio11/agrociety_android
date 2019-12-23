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
            title = "This is the title for the second post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "adsar3werfdsfseewqe",
                displayName = "Francisco Terrones",
                followers = 12,
                follow = 65,
                email = "franciscoterrones@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C4E03AQEYDOEIrBJA4g/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=ok6zwYaPdL24TzU0NNZNIeJnTqLRi5WGL4MXl-lgb8E",
                background = R.drawable.publication_example_two
            )
        ),
        Post(
            image = R.drawable.publication_example_tree,
            title = "This is the title for the third post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadsarewrewrewvcxvs",
                displayName = "Francisco Roldán Córdoba",
                followers = 23,
                follow = 54,
                email = "franciscoroldan@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C4D03AQF7f1_fsB8L9Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=IXIrlCuYFwLLh86KW22VCQX1_EGQty-hUoPWxnWTCmQ",
                background = R.drawable.publication_example_tree
            )
        ),
        Post(
            image = R.drawable.publication_example_four,
            title = "This is the title for the four post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dafdsf789478392hklfhsd",
                displayName = "Sergio Gonzalez",
                followers = 12,
                follow = 5,
                email = "sergiogonzalez@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C5603AQH-UJpm-rC6Vw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=by5w9yrq3fkoRwPFBMyStEkFz4WANDHixto4KX2nbwA",
                background = R.drawable.publication_example_four
            )
        ),
        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the five post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dasdsadsa432423bfdgfdg",
                displayName = "Jorge Martínez Marí",
                email = "jorgemartinezmari@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C4D03AQHwTcBjN6oGuQ/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=iMRyoVwBszKQ0TJQS8EicvoEVVXRhFlyXZNiU5FbafI",
                background = R.drawable.publication_example_one
            )
        ),
        Post(
            image = R.drawable.publication_example_two,
            title = "This is the title for the six post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "Gema Conde Gonzalez",
                followers = 32,
                follow = 23,
                email = "gemacondegonzalez@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C4E03AQHfhXsFSZsxdA/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=xYXQ7M7oDmY_jX4UtsMOW_gt7GgKQ-MbkpHM_Te1XfM",
                background = R.drawable.publication_example_two
            )
        ),
        Post(
            image = R.drawable.publication_example_tree,
            title = "This is the title for the seven post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "4324324sfgsgfdgfd",
                displayName = "Mª Gema Jiménez Fernández",
                followers = 22,
                follow = 22,
                email = "gemajimenezfernandez@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C5603AQETtcBGB63hAw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=BMuG3ElNVFxeuHro5U9-JjngI5XwSvlMp78EjAZyvFA",
                background = R.drawable.publication_example_tree
            )
        ),
        Post(
            image = R.drawable.publication_example_one,
            title = "This is the title for the eight post",
            date = Date(),
            likesCount = 8,
            commentsCount = 5,
            author = User(
                id = "4324324sfgsgfdgfd",
                displayName = "Mª Gema Jiménez Fernández",
                followers = 22,
                follow = 22,
                email = "gemajimenezfernandez@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C5603AQETtcBGB63hAw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=BMuG3ElNVFxeuHro5U9-JjngI5XwSvlMp78EjAZyvFA",
                background = R.drawable.publication_example_tree
            )
        )
    )


    override suspend fun onLoadData(): List<Post> =
        publications


    override suspend fun onLoadData(params: Void): List<Post> =
        publications
}