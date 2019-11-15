package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.HomeModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.HomeFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        HomeModule::class ])
interface HomeComponent: FragmentComponent {

    fun inject(homeFragment: HomeFragment)

}