package sanchez.sanchez.sergio.agrociety.ui.features.main.contactlist

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportGroupedLCEViewModel
import javax.inject.Inject

class ContactListViewModel @Inject constructor(): SupportGroupedLCEViewModel<User, Void>()  {

    private val contactList = mutableListOf(
        User(
            id = "dsadsadsadsadas",
            displayName = "David Martín Fidalgo",
            email = "davidmartin@gmail.com",
            followers = 32,
            follow = 23,
            photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
            background = R.drawable.publication_example_one
        ),
        User(
            id = "adsar3werfdsfseewqe",
            displayName = "Francisco Terrones",
            followers = 12,
            follow = 65,
            email = "franciscoterrones@gmail.com",
            photoUrl = "https://media.licdn.com/dms/image/C4E03AQEYDOEIrBJA4g/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=ok6zwYaPdL24TzU0NNZNIeJnTqLRi5WGL4MXl-lgb8E",
            background = R.drawable.publication_example_two
        ),
        User(
            id = "dsadsarewrewrewvcxvs",
            displayName = "Francisco Roldán Córdoba",
            followers = 23,
            follow = 54,
            email = "franciscoroldan@gmail.com",
            photoUrl = "https://media.licdn.com/dms/image/C4D03AQF7f1_fsB8L9Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=IXIrlCuYFwLLh86KW22VCQX1_EGQty-hUoPWxnWTCmQ",
            background = R.drawable.publication_example_tree
        ),
        User(
            id = "dafdsf789478392hklfhsd",
            displayName = "Sergio Gonzalez",
            followers = 12,
            follow = 5,
            email = "sergiogonzalez@gmail.com",
            photoUrl = "https://media.licdn.com/dms/image/C5603AQH-UJpm-rC6Vw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=by5w9yrq3fkoRwPFBMyStEkFz4WANDHixto4KX2nbwA",
            background = R.drawable.publication_example_four
        ),
        User(
            id = "dasdsadsa432423bfdgfdg",
            displayName = "Jorge Martínez Marí",
            email = "jorgemartinezmari@gmail.com",
            photoUrl = "https://media.licdn.com/dms/image/C4D03AQHwTcBjN6oGuQ/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=iMRyoVwBszKQ0TJQS8EicvoEVVXRhFlyXZNiU5FbafI",
            background = R.drawable.publication_example_one
        ),
        User(
            id = "dsadas3423432ghgfhgf",
            displayName = "Gema Conde Gonzalez",
            followers = 32,
            follow = 23,
            email = "gemacondegonzalez@gmail.com",
            photoUrl = "https://media.licdn.com/dms/image/C4E03AQHfhXsFSZsxdA/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=xYXQ7M7oDmY_jX4UtsMOW_gt7GgKQ-MbkpHM_Te1XfM",
            background = R.drawable.publication_example_two
        ),
        User(
            id = "4324324sfgsgfdgfd",
            displayName = "Mª Gema Jiménez Fernández",
            followers = 22,
            follow = 22,
            email = "gemajimenezfernandez@gmail.com",
            photoUrl = "https://media.licdn.com/dms/image/C5603AQETtcBGB63hAw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=BMuG3ElNVFxeuHro5U9-JjngI5XwSvlMp78EjAZyvFA",
            background = R.drawable.publication_example_tree
        )
    )

    override fun onCreateDataSet(params: Void?): List<User> =
        contactList

    override fun onCompareElements(elementOne: User, elementTwo: User): Int =
        elementOne.displayName.compareTo(elementTwo.displayName)

    override fun onCheckIfNextElementIsInSameGroup(
        previousElement: User,
        nextElement: User
    ): Boolean =
        previousElement.displayName.toUpperCase()[0] == nextElement.displayName.toUpperCase()[0]
}