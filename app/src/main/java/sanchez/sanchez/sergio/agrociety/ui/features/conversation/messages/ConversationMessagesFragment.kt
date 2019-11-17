package sanchez.sanchez.sergio.agrociety.ui.features.conversation.messages

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ConversationMessagesComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class ConversationMessagesFragment: SupportFragment<ConversationMessagesViewModel, Void>(ConversationMessagesViewModel::class.java) {

    private val component: ConversationMessagesComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getConversationMessagesComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int =
        R.layout.fragment_conversation_messages

    override fun onInject() {
        component.inject(this)
    }
}