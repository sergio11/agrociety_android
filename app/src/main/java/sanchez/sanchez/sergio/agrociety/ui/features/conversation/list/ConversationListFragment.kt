package sanchez.sanchez.sergio.agrociety.ui.features.conversation.list

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ConversationListComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class ConversationListFragment: SupportFragment<ConversationListViewModel, Void>(ConversationListViewModel::class.java) {

    private val component: ConversationListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getConversationListComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int =
        R.layout.fragment_conversation_list

    override fun onInject() {
        component.inject(this)
    }
}