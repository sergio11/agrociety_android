package sanchez.sanchez.sergio.agrociety.di.factory

import sanchez.sanchez.sergio.agrociety.di.components.activity.ConversationActivityComponent
import sanchez.sanchez.sergio.agrociety.di.components.activity.MainActivityComponent
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
    var mainActivityComponent: MainActivityComponent? = null
    var conversationActivityComponent: ConversationActivityComponent? = null

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


    fun getMainActivityComponent(activity: SupportActivity): MainActivityComponent =
        mainActivityComponent ?: getAppGlobalComponent(activity.application as BrownieApp)
            .mainActivityComponent(ActivityModule(activity)).also {
                mainActivityComponent = it
            }

    fun getHomeComponent(activity: SupportActivity): HomeComponent =
        getMainActivityComponent(activity).homeComponent()

    fun getDetailComponent(activity: SupportActivity): DetailComponent =
        getMainActivityComponent(activity).detailComponent()

    fun getUserProfileComponent(activity: SupportActivity): UserProfileComponent =
        getMainActivityComponent(activity).userProfileComponent()

    fun getUserSettingsComponent(activity: SupportActivity): UserSettingsComponent =
        getMainActivityComponent(activity).userSettingsComponent()

    fun getNewsBoardComponent(activity: SupportActivity): NewsBoardComponent =
        getMainActivityComponent(activity).newsBoardComponent()

    fun getEventsComponent(activity: SupportActivity): EventsComponent =
        getMainActivityComponent(activity).eventsComponent()

    fun getPersonalBoardComponent(activity: SupportActivity): PersonalBoardComponent =
        getMainActivityComponent(activity).personalBoardComponent()

    fun getUserPostBoardComponent(activity: SupportActivity): UserPostBoardComponent =
        getMainActivityComponent(activity).userPostBoardComponent()

    fun getLastAnnouncementsComponent(activity: SupportActivity): LastAnnouncementsComponent =
        getMainActivityComponent(activity).lastAnnouncementsComponent()

    fun getContactListComponent(activity: SupportActivity): ContactListComponent =
        getMainActivityComponent(activity).contactListComponent()

    fun getUserDetailComponent(activity: SupportActivity): UserDetailComponent =
        getMainActivityComponent(activity).userDetailComponent()

    fun getSplashActivityComponent(activity: SupportActivity): SplashActivityComponent =
        splashActivityComponent ?: getAppGlobalComponent(activity.application as BrownieApp)
            .splashActivityComponent(ActivityModule(activity)).also {
                splashActivityComponent = it
            }

    fun getSplashComponent(activity: SupportActivity): SplashComponent =
        getSplashActivityComponent(activity).splashComponent()


    fun getConversationActivityComponent(activity: SupportActivity): ConversationActivityComponent =
        conversationActivityComponent ?: getAppGlobalComponent(activity.application as BrownieApp)
            .conversationActivityComponent(ActivityModule(activity)).also {
                conversationActivityComponent  = it
            }

    fun getConversationListComponent(activity: SupportActivity): ConversationListComponent =
        getConversationActivityComponent(activity).conversationListComponent()

    fun getConversationMessagesComponent(activity: SupportActivity): ConversationMessagesComponent =
        getConversationActivityComponent(activity).conversationMessagesComponent()
}