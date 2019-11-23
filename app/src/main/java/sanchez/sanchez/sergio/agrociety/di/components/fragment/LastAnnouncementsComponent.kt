package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.LastAnnouncementsModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.lastannouncements.LastAnnouncementsFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        LastAnnouncementsModule::class ])
interface LastAnnouncementsComponent: FragmentComponent {

    fun inject(lastAnnouncementsFragment: LastAnnouncementsFragment)
}