package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.SearchModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.SearchByCategoryFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.SearchFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        SearchModule::class ])
interface SearchComponent: FragmentComponent {

    fun inject(searchFragment: SearchFragment)
    fun inject(searchByCategoryFragment: SearchByCategoryFragment)
}