package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.*
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.SearchFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.announcements.SearchAnnouncementsFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.event.SearchEventFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.post.SearchPostFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.user.SearchUserFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        SearchModule::class,
        SearchPostModule::class,
        SearchUserModule::class,
        SearchEventModule::class,
        SearchAnnouncementsModule::class
    ])
interface SearchComponent: FragmentComponent {

    fun inject(searchFragment: SearchFragment)
    fun inject(searchPostFragment: SearchPostFragment)
    fun inject(searchAnnouncementsFragment: SearchAnnouncementsFragment)
    fun inject(searchEventFragment: SearchEventFragment)
    fun inject(searchUserFragment: SearchUserFragment)
}