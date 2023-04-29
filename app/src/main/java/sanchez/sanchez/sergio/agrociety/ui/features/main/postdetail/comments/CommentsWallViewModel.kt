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
                displayName = "User 1",
                email = "user1@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_one
            )
        ),
        Comment(
            id = "dsajdklsaj43834",
            text = "Esto es un comentario de prueba",
            author = User(
                id = "dasdsadsa432423bfdgfdg",
                displayName = "User 2",
                email = "user2@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_one
            )
        ),
        Comment(
            id = "jdkaslda78973894",
            text = "Esto es un comentario de prueba",
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
        Comment(
            id = "jdkasldasu7364378",
            text = "Esto es un comentario de prueba",
            author = User(
                id = "4324324sfgsgfdgfd",
                displayName = "User 4",
                followers = 22,
                follow = 22,
                email = "user4@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_tree
            )
        ),
        Comment(
            id = "dkldajkshdafjgdh63",
            text = "Esto es un comentario de prueba",
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
        Comment(
            id = "ewqewqewq3214324324",
            text = "Esto es un comentario de prueba",
            author = User(
                id = "dsadas3423432ghgfhgf",
                displayName = "User 6",
                followers = 32,
                follow = 23,
                email = "user6@gmail.com",
                photoUrl = "",
                background = R.drawable.publication_example_two
            )
        )
    )


    override suspend fun onLoadData(): List<Comment> =
        comments

    override suspend fun onLoadData(params: Void): List<Comment> =
        comments

}
