package sanchez.sanchez.sergio.agrociety.di.components.activity

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.MainComponent
import sanchez.sanchez.sergio.agrociety.ui.features.home.HomeActivity
import sanchez.sanchez.sergio.brownie.di.components.ActivityComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerActivity

@PerActivity
@Subcomponent(modules = [
    ActivityModule::class
])
interface HomeActivityComponent: ActivityComponent {

    fun inject(activity: HomeActivity)

    fun mainComponent(): MainComponent
}