package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.EventsModule
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.UpcomingEventsModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.events.EventsFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.upcomingevents.UpcomingEventsFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        UpcomingEventsModule::class,
        EventsModule::class])
interface EventsComponent: FragmentComponent {

    fun inject(upcomingEventsFragment: UpcomingEventsFragment)
    fun inject(eventsFragment: EventsFragment)
}