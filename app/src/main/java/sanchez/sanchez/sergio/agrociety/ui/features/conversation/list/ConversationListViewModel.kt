package sanchez.sanchez.sergio.agrociety.ui.features.conversation.list

import sanchez.sanchez.sergio.agrociety.domain.model.Conversation
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class ConversationListViewModel @Inject constructor(): SupportLCEViewModel<Conversation, Void>() {

    private val conversations = mutableListOf(
        Conversation(
            targetName = "User 1",
            targetImageUrl = "",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 4
        ),
        Conversation(
            targetName = "User 2",
            targetImageUrl = "",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 2
        ),
        Conversation(
            targetName = "User 3",
            targetImageUrl = "",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 0
        ),
        Conversation(
            targetName = "User 4",
            targetImageUrl = "",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 1),
        Conversation(
            targetName = "User 5",
            targetImageUrl = "",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 6
        ),
        Conversation(
            targetName = "User 6",
            targetImageUrl = "",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 1
        ),
        Conversation(
            targetName = "User 7",
            targetImageUrl = "",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 0
        )
    )

    override suspend fun onLoadData(): List<Conversation> =
        conversations

    override suspend fun onLoadData(params: Void): List<Conversation> =
        conversations
}
