package sanchez.sanchez.sergio.agrociety.di.components.activity

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.*
import sanchez.sanchez.sergio.agrociety.ui.features.home.HomeActivity
import sanchez.sanchez.sergio.brownie.di.components.ActivityComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerActivity
import sanchez.sanchez.sergio.agrociety.ui.features.intro.IntroActivity

@PerActivity
@Subcomponent(modules = [
    ActivityModule::class
    ])
interface IntroActivityComponent: ActivityComponent {

    fun inject(activity: IntroActivity)

    fun splashScreenComponent(): SplashScreenComponent
    fun loginComponent(): LoginComponent
    fun resetPasswordComponent(): ResetPasswordComponent
    fun signupComponent(): SignupComponent
    fun setLocationComponent(): SetLocationComponent


}