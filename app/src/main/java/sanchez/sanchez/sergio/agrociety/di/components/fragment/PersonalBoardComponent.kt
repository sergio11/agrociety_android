package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.PersonalBoardModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.personalboard.PersonalBoardFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        PersonalBoardModule::class ])
interface PersonalBoardComponent: FragmentComponent {

    fun inject(personalBoardFragment: PersonalBoardFragment)
}