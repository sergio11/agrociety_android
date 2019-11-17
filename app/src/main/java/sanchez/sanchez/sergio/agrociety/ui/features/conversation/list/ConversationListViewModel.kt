package sanchez.sanchez.sergio.agrociety.ui.features.conversation.list

import sanchez.sanchez.sergio.agrociety.domain.model.Conversation
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import javax.inject.Inject

class ConversationListViewModel @Inject constructor(): SupportLCEViewModel<Conversation, Void>() {

    private val conversations = mutableListOf(
        Conversation(),
        Conversation(),
        Conversation(),
        Conversation(),
        Conversation()
    )

    override suspend fun onLoadData(): List<Conversation> =
        conversations

    override suspend fun onLoadData(params: Void): List<Conversation> =
        conversations
}