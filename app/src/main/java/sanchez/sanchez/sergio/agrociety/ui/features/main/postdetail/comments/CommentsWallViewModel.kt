package sanchez.sanchez.sergio.agrociety.ui.features.main.postdetail.comments

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.Comment
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import javax.inject.Inject

class CommentsWallViewModel @Inject constructor(): SupportLCEViewModel<Comment, Void>() {

    val comments = mutableListOf(
        Comment(
            id = "dsjakdljsaur837",
            text = "Esto es un comentario de prueba",
            author = User(
                id = "dasdsadsa432423bfdgfdg",
                displayName = "Jorge Martínez Marí",
                email = "jorgemartinezmari@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C4D03AQHwTcBjN6oGuQ/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=iMRyoVwBszKQ0TJQS8EicvoEVVXRhFlyXZNiU5FbafI",
                background = R.drawable.publication_example_one
            )
        ),
        Comment(
            id = "dsajdklsaj43834",
            text = "Esto es un comentario de prueba",
            author = User(
                id = "dasdsadsa432423bfdgfdg",
                displayName = "Jorge Martínez Marí",
                email = "jorgemartinezmari@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C4D03AQHwTcBjN6oGuQ/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=iMRyoVwBszKQ0TJQS8EicvoEVVXRhFlyXZNiU5FbafI",
                background = R.drawable.publication_example_one
            )
        ),
        Comment(
            id = "jdkaslda78973894",
            text = "Esto es un comentario de prueba",
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
        Comment(
            id = "jdkasldasu7364378",
            text = "Esto es un comentario de prueba",
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
        Comment(
            id = "dkldajkshdafjgdh63",
            text = "Esto es un comentario de prueba",
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
        Comment(
            id = "ewqewqewq3214324324",
            text = "Esto es un comentario de prueba",
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "Gema Conde Gonzalez",
                followers = 32,
                follow = 23,
                email = "gemacondegonzalez@gmail.com",
                photoUrl = "https://media.licdn.com/dms/image/C4E03AQHfhXsFSZsxdA/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=xYXQ7M7oDmY_jX4UtsMOW_gt7GgKQ-MbkpHM_Te1XfM",
                background = R.drawable.publication_example_two
            )
        )
    )


    override suspend fun onLoadData(): List<Comment> =
        comments

    override suspend fun onLoadData(params: Void): List<Comment> =
        comments

}