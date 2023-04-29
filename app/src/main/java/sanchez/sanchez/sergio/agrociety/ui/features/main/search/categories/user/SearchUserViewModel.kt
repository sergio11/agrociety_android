package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.user

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportGroupedLCEViewModel
import javax.inject.Inject

class SearchUserViewModel @Inject constructor(): SupportGroupedLCEViewModel<User, Void>() {

    private val users = mutableListOf(
        User(
            id = "dsadsadsadsadas",
            displayName = "User 1",
            email = "user1@gmail.com",
            followers = 32,
            follow = 23,
            photoUrl = "",
            background = R.drawable.publication_example_one
        ),
        User(
            id = "adsar3werfdsfseewqe",
            displayName = "User 2",
            followers = 12,
            follow = 65,
            email = "user2@gmail.com",
            photoUrl = "",
            background = R.drawable.publication_example_two
        ),
        User(
            id = "dsadsarewrewrewvcxvs",
            displayName = "User 3",
            followers = 23,
            follow = 54,
            email = "user3@gmail.com",
            photoUrl = "",
            background = R.drawable.publication_example_tree
        ),
        User(
            id = "dafdsf789478392hklfhsd",
            displayName = "User 4",
            followers = 12,
            follow = 5,
            email = "user4@gmail.com",
            photoUrl = "",
            background = R.drawable.publication_example_four
        ),
        User(
            id = "dasdsadsa432423bfdgfdg",
            displayName = "User 5",
            email = "user5@gmail.com",
            photoUrl = "",
            background = R.drawable.publication_example_one
        ),
        User(
            id = "dsadas3423432ghgfhgf",
            displayName = "User 6",
            followers = 32,
            follow = 23,
            email = "user6@gmail.com",
            photoUrl = "",
            background = R.drawable.publication_example_two
        ),
        User(
            id = "4324324sfgsgfdgfd",
            displayName = "User 7",
            followers = 22,
            follow = 22,
            email = "user7@gmail.com",
            photoUrl = "",
            background = R.drawable.publication_example_tree
        )
    )


    override fun onCompareElements(elementOne: User, elementTwo: User): Int =
        when {
            elementOne.followers > elementTwo.followers -> -1
            elementOne.followers == elementTwo.followers -> 0
            else -> 1
        }

    override fun onCheckIfNextElementIsInSameGroup(
        previousElement: User,
        nextElement: User
    ): Boolean =
        previousElement.followers >= MIN_FOLLOWERS_COUNT &&
                nextElement.followers >= MIN_FOLLOWERS_COUNT ||
                previousElement.followers < MIN_FOLLOWERS_COUNT &&
                nextElement.followers < MIN_FOLLOWERS_COUNT

    /**
     * Create DATA SET
     */
    override fun onCreateDataSet(params: Void?): List<User> =
        users


    companion object {
        const val MIN_FOLLOWERS_COUNT = 30
    }
}


