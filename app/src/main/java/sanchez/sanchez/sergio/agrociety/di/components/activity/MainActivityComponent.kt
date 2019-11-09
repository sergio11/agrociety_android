package sanchez.sanchez.sergio.agrociety.di.components.activity

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.DetailComponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.HomeComponent
import sanchez.sanchez.sergio.agrociety.ui.features.main.MainActivity
import sanchez.sanchez.sergio.brownie.di.components.ActivityComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerActivity

@PerActivity
@Subcomponent(modules = [
    ActivityModule::class
])
interface MainActivityComponent: ActivityComponent {

    fun inject(activity: MainActivity)

    fun homeComponent(): HomeComponent
    fun detailComponent(): DetailComponent
}