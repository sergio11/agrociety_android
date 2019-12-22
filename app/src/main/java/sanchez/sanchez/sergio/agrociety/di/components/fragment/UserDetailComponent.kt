package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.UserDetailModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.userdetail.UserDetailFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        UserDetailModule::class ])
interface UserDetailComponent: FragmentComponent {

    fun inject(userDetailFragment: UserDetailFragment)
}