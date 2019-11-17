package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.ConversationListModule
import sanchez.sanchez.sergio.agrociety.ui.features.conversation.list.ConversationListFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        ConversationListModule::class ])
interface ConversationListComponent: FragmentComponent {

    fun inject(conversationListFragment: ConversationListFragment)
}