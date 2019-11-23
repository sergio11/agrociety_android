package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.conversation.ConversationUtilsModule
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.ConversationMessagesModule
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.UserProfileModule
import sanchez.sanchez.sergio.agrociety.ui.features.conversation.messages.ConversationMessagesFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.profile.UserProfileFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        ConversationMessagesModule::class,
        ConversationUtilsModule::class])
interface ConversationMessagesComponent: FragmentComponent {

    fun inject(conversationMessagesFragment: ConversationMessagesFragment)
}