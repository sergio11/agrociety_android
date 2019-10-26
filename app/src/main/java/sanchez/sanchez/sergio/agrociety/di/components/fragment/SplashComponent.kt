package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.SplashModule
import sanchez.sanchez.sergio.agrociety.ui.features.splash.SplashFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        SplashModule::class ])
interface SplashComponent: FragmentComponent {

    fun inject(splashFragment: SplashFragment)
}