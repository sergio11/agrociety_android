package sanchez.sanchez.sergio.agrociety.ui.features.conversation.list

import sanchez.sanchez.sergio.agrociety.domain.model.Conversation
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import java.util.*
import javax.inject.Inject

class ConversationListViewModel @Inject constructor(): SupportLCEViewModel<Conversation, Void>() {

    private val conversations = mutableListOf(
        Conversation(
            targetName = "Sergio Sánchez Sánchez",
            targetImageUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 4
        ),
        Conversation(
            targetName = "Francisco Terrones",
            targetImageUrl = "https://media.licdn.com/dms/image/C4E03AQEYDOEIrBJA4g/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=ok6zwYaPdL24TzU0NNZNIeJnTqLRi5WGL4MXl-lgb8E",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 2
        ),
        Conversation(
            targetName = "Francisco Roldán Córdoba",
            targetImageUrl = "https://media.licdn.com/dms/image/C4D03AQF7f1_fsB8L9Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=IXIrlCuYFwLLh86KW22VCQX1_EGQty-hUoPWxnWTCmQ",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 0
        ),
        Conversation(
            targetName = "Sergio Gonzalez",
            targetImageUrl = "https://media.licdn.com/dms/image/C5603AQH-UJpm-rC6Vw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=by5w9yrq3fkoRwPFBMyStEkFz4WANDHixto4KX2nbwA",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 1),
        Conversation(
            targetName = "Jorge Martínez Marí",
            targetImageUrl = "https://media.licdn.com/dms/image/C4D03AQHwTcBjN6oGuQ/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=iMRyoVwBszKQ0TJQS8EicvoEVVXRhFlyXZNiU5FbafI",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 6
        ),
        Conversation(
            targetName = "Gema Conde Gonzalez",
            targetImageUrl = "https://media.licdn.com/dms/image/C4E03AQHfhXsFSZsxdA/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=xYXQ7M7oDmY_jX4UtsMOW_gt7GgKQ-MbkpHM_Te1XfM",
            lastMessage = "Este es un mensaje de prueba",
            lastUpdate = Date(),
            messageNotReadCount = 1
        ),
        Conversation(
            targetName = "Mª Gema Jiménez Fernández",
            targetImageUrl = "https://media.licdn.com/dms/image/C5603AQETtcBGB63hAw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=BMuG3ElNVFxeuHro5U9-JjngI5XwSvlMp78EjAZyvFA",
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