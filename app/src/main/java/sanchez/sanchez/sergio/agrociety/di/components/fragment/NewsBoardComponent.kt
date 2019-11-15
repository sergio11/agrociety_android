package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.NewsBoardModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.newsboard.NewsBoardFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        NewsBoardModule::class ])
interface NewsBoardComponent: FragmentComponent {

    fun inject(newsBoardFragment: NewsBoardFragment)
}