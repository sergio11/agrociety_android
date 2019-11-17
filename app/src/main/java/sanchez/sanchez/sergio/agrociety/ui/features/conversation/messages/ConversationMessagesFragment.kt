package sanchez.sanchez.sergio.agrociety.ui.features.conversation.messages

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.stfalcon.chatkit.commons.ImageLoader
import com.stfalcon.chatkit.messages.MessageInput
import com.stfalcon.chatkit.messages.MessagesListAdapter
import com.stfalcon.chatkit.utils.DateFormatter
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_conversation_messages.*
import kotlinx.android.synthetic.main.fragment_conversation_messages.container
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ConversationMessagesComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.conversation.models.ConversationMessage
import sanchez.sanchez.sergio.agrociety.ui.features.conversation.models.ConversationMessageUser
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class ConversationMessagesFragment: SupportFragment<ConversationMessagesViewModel, Void>(ConversationMessagesViewModel::class.java),
    MessageInput.InputListener, MessagesListAdapter.SelectionListener, MessagesListAdapter.OnLoadMoreListener, DateFormatter.Formatter, SwipeRefreshLayout.OnRefreshListener{

    private val component: ConversationMessagesComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getConversationMessagesComponent(activity as SupportActivity)
    }

    private val SENDER_ID = "4324324"
    private val SENDING_MESSAGE_ID = "5645678"
    private val CONVERSATION_ID_DEFAULT = "FDAFDSFSDF432432"
    private val TARGET_ID = "FDSFDSFDSFT34543345"

    /**
     * Inject Image Loader for Message adapter
     */
    @Inject
    lateinit var imageLoader: ImageLoader


    /**
     * Selection Count
     */
    var selectionCount: Int = 0

    /**
     * Message List Adapter
     */
    private val messagesAdapter: MessagesListAdapter<ConversationMessage> by lazy {
        MessagesListAdapter<ConversationMessage>(SENDER_ID, imageLoader).also {
            it.enableSelectionMode(this)
            it.setLoadMoreListener(this)
            it.setDateHeadersFormatter(this)
        }
    }

    override fun layoutId(): Int =
        R.layout.fragment_conversation_messages


    override fun onInject() {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.operationResult.observe(this, Observer {
            when(it) {
                ConversationMessagesOperationResultEnum.LOADED ->
                    onConversationMessagesLoaded()
                ConversationMessagesOperationResultEnum.ADDED ->
                    onMessageAdded(viewModel.lastMessageLiveData.value!!)
                ConversationMessagesOperationResultEnum.NOT_FOUND ->
                    onNoConversationMessagesFound()
                else ->
                    onError()
            }
        })
    }

    override fun onStart() {
        super.onStart()
        conversationBackground.resume()
    }

    override fun onStop() {
        super.onStop()
        conversationBackground.pause()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        input.setInputListener(this)
        messagesList.setAdapter(messagesAdapter)

        conversationMessagesBlurView.setupWith(container)
            .setFrameClearDrawable(container.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(4.0f)
            .setHasFixedTransformationMatrix(true)

        content.setOnRefreshListener(this)

        viewModel.loadMessages(CONVERSATION_ID_DEFAULT)
    }

    override fun onSubmit(input: CharSequence?): Boolean {
        Timber.d("onSubmit -> $input")
        messagesAdapter.addToStart(getSendingConversationMessage(), true)
        viewModel.addMessage(
            CONVERSATION_ID_DEFAULT,
            input.toString(),
            SENDER_ID,
            TARGET_ID)
        return true
    }

    override fun onSelectionChanged(count: Int) {
        Timber.d("onSelectionChanged")
        selectionCount = count
    }

    override fun onLoadMore(page: Int, totalItemsCount: Int) {
        Timber.d("onLoadMore")
    }

    override fun format(date: Date?): String? {
        Timber.d("format")
        return null
    }

    override fun onRefresh() {
        Timber.d("onRefresh")
        viewModel.loadMessages(CONVERSATION_ID_DEFAULT)
    }

    /**
     * Private Methods
     * ==================
     */

    /**
     * On Conversation Messages Loaded
     */
    private fun onConversationMessagesLoaded() {

        content.isRefreshing = false

        val userFrom = ConversationMessageUser(
            id = SENDER_ID,
            name = "Sergio Sánchez Sánchez",
            avatar = "https://avatars3.githubusercontent.com/u/6996211?s=460&v=4"
        )

        val userTarget = ConversationMessageUser(
            id = TARGET_ID,
            name = "José María Herrero Calle",
            avatar = "https://media.licdn.com/dms/image/C5603AQE0j_adDKeE3w/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=bV1iCQshpjc4Sw4EiwFsOrl54f5MnSLnp7Z6FXiSDjs"
        )

        messagesAdapter.clear(true)
        messagesAdapter.addToEnd(arrayListOf(
            ConversationMessage(
                id = "4324dsadfdsfdsfsdfd2jkfhds824739",
                user = userFrom,
                text = "Mensaje de Prueba 5"
            ),
            ConversationMessage(
                id = "4324dsadsa12433rewrwerwe434739",
                user = userTarget,
                text = "Mensaje de Prueba 4"
            ),
            ConversationMessage(
                id = "4324dsadsa124332jkfhds824739",
                user = userFrom,
                text = "Mensaje de Prueba 3"
            ),
            ConversationMessage(
                id = "432432fdsf34fhsdjkfhds824739",
                user = userTarget,
                text = "Mensaje de Prueba 2"
            ),
            ConversationMessage(
                id = "432432fdsf34234324324",
                user = userFrom,
                text = "Mensaje de Prueba 1"
            )
        ), false)

    }

    /**
     * On No Conversation Messages Found
     */
    private fun onNoConversationMessagesFound() {}

    /**
     * On Message Added
     */
    private fun onMessageAdded(message: String) {
        messagesAdapter.deleteById(SENDING_MESSAGE_ID);
        addMessageToList(
            messageId = "3732849624hfjksdhfkjdshf",
            fromId = SENDER_ID,
            fromFullname = "Sergio Sánchez Sánchez",
            fromProfileImage = "https://avatars3.githubusercontent.com/u/6996211?s=460&v=4",
            messageText = message
        )
    }

    /**
     * On Error
     */
    private fun onError() {}

    /**
     * Get Sending Conversation Message
     * @return
     */
    private fun getSendingConversationMessage(): ConversationMessage {
        return ConversationMessage(
            id = SENDING_MESSAGE_ID,
            user = ConversationMessageUser(
                id = SENDER_ID,
                name = "Sergio",
                avatar = "https://avatars3.githubusercontent.com/u/6996211?s=460&v=4"
            ),
            text = getString(R.string.sending_message_wait)
        )
    }

    private fun addMessageToList(
        messageId: String, fromId: String, fromFullname: String,
        fromProfileImage: String, messageText: String
    ) {
        messagesAdapter.addToStart(
            ConversationMessage(
                id = messageId,
                user = ConversationMessageUser(
                    id = fromId,
                    name = fromFullname,
                    avatar = fromProfileImage
                ),
                text = messageText
            ), true
        )
    }

}