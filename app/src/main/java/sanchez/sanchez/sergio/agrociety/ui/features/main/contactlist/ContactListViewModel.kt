package sanchez.sanchez.sergio.agrociety.ui.features.main.contactlist

import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportGroupedLCEViewModel
import javax.inject.Inject

class ContactListViewModel @Inject constructor(): SupportGroupedLCEViewModel<User, Void>()  {

    private val contactList = mutableListOf(
        User(
            displayName = "David Martín Fidalgo",
            email = "david@gmail.com"
        ),
        User(
            displayName = "Alejandro Pérez",
            email = "alejandro@gmail.com"
        ),
        User(
            displayName = "David Muñoz",
            email = "david@gmail.com"
        ),
        User(
            displayName = "María Sánchez Muñoz",
            email = "maria@gmail.com"
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