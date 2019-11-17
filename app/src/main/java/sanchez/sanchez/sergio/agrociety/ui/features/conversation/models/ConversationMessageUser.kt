package sanchez.sanchez.sergio.agrociety.ui.features.conversation.models

import com.stfalcon.chatkit.commons.models.IUser

data class ConversationMessageUser(
    private val avatar: String,
    private val name: String,
    private val id: String): IUser {

    override fun getId(): String = id
    override fun getAvatar(): String = avatar
    override fun getName(): String = name

}