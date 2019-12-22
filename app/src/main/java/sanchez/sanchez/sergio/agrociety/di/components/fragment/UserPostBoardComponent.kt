package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.UserPostBoardModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.common.userpost.UserPostBoardFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        UserPostBoardModule::class ])
interface UserPostBoardComponent: FragmentComponent {

    fun inject(userPostBoardFragment: UserPostBoardFragment)
}