package sanchez.sanchez.sergio.agrociety.ui.features.conversation.models

import com.stfalcon.chatkit.commons.models.IMessage
import com.stfalcon.chatkit.commons.models.IUser
import com.stfalcon.chatkit.commons.models.MessageContentType
import java.util.*

class ConversationMessage(
    private val id: String ,
    private val user: ConversationMessageUser,
    private val text: String,
    private val createdAt: Date? = null,
    private val imageUrl: String? = null
): IMessage, MessageContentType.Image, MessageContentType {

    override fun getId(): String = id
    override fun getCreatedAt(): Date = createdAt ?: Date()
    override fun getUser(): IUser = user
    override fun getText(): String = text
    override fun getImageUrl(): String? = imageUrl
}