package sanchez.sanchez.sergio.agrociety.domain.model

import java.util.*

data class Conversation(
    val targetName: String,
    val targetImageUrl: String? = null,
    val lastUpdate: Date,
    val lastMessage: String,
    val messageNotReadCount: Int
)