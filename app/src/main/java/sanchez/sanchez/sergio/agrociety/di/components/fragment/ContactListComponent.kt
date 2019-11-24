package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.ContactsListModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.contactlist.ContactListFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [ ContactsListModule::class ])
interface ContactListComponent: FragmentComponent {

    fun inject(contactListFragment: ContactListFragment)
}