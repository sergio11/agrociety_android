package sanchez.sanchez.sergio.agrociety.ui.features.conversation.messages

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject

class ConversationMessagesViewModel @Inject constructor(): SupportViewModel() {

    val operationResult: MutableLiveData<ConversationMessagesOperationResultEnum> by lazy {
        MutableLiveData<ConversationMessagesOperationResultEnum>()
    }

    val lastMessageLiveData: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun loadMessages(conversationId: String) = viewModelScope.launch {
        operationResult.postValue(ConversationMessagesOperationResultEnum.LOADED)
    }

    fun addMessage(
        conversationId: String,
        message: String,
        currentUserId: String,
        userTargetId: String) = viewModelScope.launch {

        lastMessageLiveData.postValue(message)
        operationResult.postValue(ConversationMessagesOperationResultEnum.ADDED)

    }

}