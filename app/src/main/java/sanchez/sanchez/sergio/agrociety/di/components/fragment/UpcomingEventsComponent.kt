package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.UpcomingEventsModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.upcomingevents.UpcomingEventsFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        UpcomingEventsModule::class ])
interface UpcomingEventsComponent: FragmentComponent {

    fun inject(upcomingEventsFragment: UpcomingEventsFragment)
}