package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.DetailModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.detail.DetailFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        DetailModule::class ])
interface DetailComponent: FragmentComponent {

    fun inject(detailFragment: DetailFragment)
}