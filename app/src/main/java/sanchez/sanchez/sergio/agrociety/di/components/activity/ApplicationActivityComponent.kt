package sanchez.sanchez.sergio.agrociety.di.components.activity

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.LoginComponent
import sanchez.sanchez.sergio.brownie.di.components.ActivityComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerActivity
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SplashScreenComponent
import sanchez.sanchez.sergio.agrociety.ui.features.IntroActivity

@PerActivity
@Subcomponent(modules = [
    ActivityModule::class
    ])
interface ApplicationActivityComponent: ActivityComponent {

    fun inject(activity: IntroActivity)

    fun splashScreenComponent(): SplashScreenComponent
    fun loginComponent(): LoginComponent


}