package sanchez.sanchez.sergio.agrociety.di.components.application

import dagger.Component
import sanchez.sanchez.sergio.agrociety.di.components.activity.HomeActivityComponent
import sanchez.sanchez.sergio.brownie.di.components.ApplicationComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerApplication
import sanchez.sanchez.sergio.agrociety.di.components.activity.IntroActivityComponent
import sanchez.sanchez.sergio.healthycitizen.di.modules.UtilsModule

@PerApplication
@Component(dependencies = [ApplicationComponent::class],
    modules = [
        UtilsModule::class])
interface ApplicationGlobalComponent{

    fun introActivityComponent(activityModule: ActivityModule) : IntroActivityComponent

    fun homeActivityComponent(activityModule: ActivityModule): HomeActivityComponent



}