package sanchez.sanchez.sergio.agrociety.di.components.activity

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ConversationListComponent
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ConversationMessagesComponent
import sanchez.sanchez.sergio.agrociety.ui.features.conversation.ConversationActivity
import sanchez.sanchez.sergio.brownie.di.components.ActivityComponent
import sanchez.sanchez.sergio.brownie.di.modules.ActivityModule
import sanchez.sanchez.sergio.brownie.di.scopes.PerActivity

@PerActivity
@Subcomponent(modules = [
    ActivityModule::class
])
interface ConversationActivityComponent: ActivityComponent {

    fun inject(activity: ConversationActivity)

    fun conversationListComponent(): ConversationListComponent
    fun conversationMessagesComponent(): ConversationMessagesComponent

}