package sanchez.sanchez.sergio.agrociety.di.factory

import sanchez.sanchez.sergio.agrociety.di.components.activity.HomeActivityComponent
import sanchez.sanchez.sergio.agrociety.di.components.activity.IntroActivityComponent
import sanchez.sanchez.sergio.agrociety.di.components.activity.SplashActivityComponent
import sanchez.sanchez.sergio.agrociety.di.components.application.ApplicationGlobalComponent
import sanchez.sanchez.sergio.agrociety.di.components.application.DaggerApplicationGlobalComponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.*
import sanchez.sanchez.sergio.brownie.BrownieApp
import sanchez.sanchez.sergio.brownie.di.components.ApplicationComponent
import sanchez.sanchez.sergio.brownie.di.components.DaggerApplicationComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.modules.ApplicationModule
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity


object DaggerComponentFactory {

    private var appComponent: ApplicationComponent? = null
    private var appGlobalComponent: ApplicationGlobalComponent? = null


    var splashActivityComponent: SplashActivityComponent? = null
    var introActivityComponent: IntroActivityComponent? = null
    var homeActivityComponent: HomeActivityComponent? = null

    fun getAppComponent(app: BrownieApp): ApplicationComponent =
        appComponent ?: DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(app))
            .build().also {
                appComponent = it
            }

    fun getAppGlobalComponent(app: BrownieApp): ApplicationGlobalComponent =
        appGlobalComponent ?: DaggerApplicationGlobalComponent.builder()
            .applicationComponent(getAppComponent(app))
            .build().also {
                appGlobalComponent = it
            }

    fun getIntroActivityComponent(activity: SupportActivity): IntroActivityComponent =
        introActivityComponent ?: getAppGlobalComponent(activity.application as BrownieApp)
            .introActivityComponent(ActivityModule(activity)).also {
                introActivityComponent = it
            }


    fun getLoginComponent(activity: SupportActivity): LoginComponent =
        getIntroActivityComponent(activity).loginComponent()

    fun getResetPasswordComponent(activity: SupportActivity): ResetPasswordComponent =
        getIntroActivityComponent(activity).resetPasswordComponent()

    fun getSignupComponent(activity: SupportActivity): SignupComponent =
        getIntroActivityComponent(activity).signupComponent()

    fun getSetLocationComponent(activity: SupportActivity): SetLocationComponent =
        getIntroActivityComponent(activity).setLocationComponent()


    fun getHomeActivityComponent(activity: SupportActivity): HomeActivityComponent =
        homeActivityComponent ?: getAppGlobalComponent(activity.application as BrownieApp)
            .homeActivityComponent(ActivityModule(activity)).also {
                homeActivityComponent = it
            }

    fun getMainComponent(activity: SupportActivity): MainComponent =
        getHomeActivityComponent(activity).mainComponent()


    fun getSplashActivityComponent(activity: SupportActivity): SplashActivityComponent =
        splashActivityComponent ?: getAppGlobalComponent(activity.application as BrownieApp)
            .splashActivityComponent(ActivityModule(activity)).also {
                splashActivityComponent = it
            }

    fun getSplashComponent(activity: SupportActivity): SplashComponent =
        getSplashActivityComponent(activity).splashComponent()


}