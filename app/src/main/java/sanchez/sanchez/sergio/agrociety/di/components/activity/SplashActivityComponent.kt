package sanchez.sanchez.sergio.agrociety.di.components.activity

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SplashComponent
import sanchez.sanchez.sergio.agrociety.ui.features.splash.SplashScreenActivity
import sanchez.sanchez.sergio.brownie.di.components.ActivityComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerActivity

@PerActivity
@Subcomponent(modules = [
    ActivityModule::class
])
interface SplashActivityComponent: ActivityComponent {

    fun inject(activity: SplashScreenActivity)

    fun splashComponent(): SplashComponent
}