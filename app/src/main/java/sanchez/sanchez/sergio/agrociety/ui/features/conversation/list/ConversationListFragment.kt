package sanchez.sanchez.sergio.agrociety.ui.features.conversation.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ConversationListComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Conversation
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportItemTouchHelper
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import timber.log.Timber

class ConversationListFragment: SupportLCEFragment<Void, Conversation, Void, ConversationListViewModel>(ConversationListViewModel::class.java) {

    private val component: ConversationListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getConversationListComponent(activity as SupportActivity)
    }

    private val conversationsAdapter: ConversationsAdapter by lazy {
        ConversationsAdapter(requireContext(), ArrayList())
    }

    override fun layoutId(): Int =
        R.layout.fragment_conversation_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // adding item touch helper
        val itemTouchHelperCallback = SupportItemTouchHelper<Conversation, ConversationsAdapter.ConversationViewHolder>(0, ItemTouchHelper.LEFT, this)
        ItemTouchHelper(itemTouchHelperCallback)
            .attachToRecyclerView(recyclerView)
    }

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Conversation> =
        conversationsAdapter

    override fun onItemClick(item: Conversation) {
        navigate(R.id.action_conversationListFragment_to_conversationMessagesFragment)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
        Timber.d("On Swiped")
        conversationsAdapter.removeItem(position)
    }
}