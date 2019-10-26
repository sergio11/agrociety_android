package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.SetLocationModule
import sanchez.sanchez.sergio.agrociety.ui.features.intro.location.SetLocationFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        SetLocationModule::class ])
interface SetLocationComponent: FragmentComponent {

    fun inject(setLocationFragment: SetLocationFragment)
}