package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.MainModule
import sanchez.sanchez.sergio.agrociety.ui.features.home.main.MainFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        MainModule::class ])
interface MainComponent: FragmentComponent {

    fun inject(mainFragment: MainFragment)
}