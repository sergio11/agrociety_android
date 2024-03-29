package sanchez.sanchez.sergio.agrociety.ui.features.conversation.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ConversationListComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Conversation
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportItemTouchHelper
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_conversation_list.*
import sanchez.sanchez.sergio.agrociety.ui.features.main.MainActivity
import sanchez.sanchez.sergio.brownie.extension.*
import sanchez.sanchez.sergio.brownie.ui.dialogs.impl.ConfirmationDialogFragment
import javax.inject.Inject


class ConversationListFragment: SupportLCEFragment<Void, Conversation, Void, ConversationListViewModel>(ConversationListViewModel::class.java) {

    private val component: ConversationListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getConversationListComponent(activity as SupportActivity)
    }

    private lateinit var conversationsAdapter: ConversationsAdapter

    @Inject
    lateinit var picasso: Picasso

    override fun layoutId(): Int =
        R.layout.fragment_conversation_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.conversation_list_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.deleteAllConversation)
          showConfirmationDialog(
              title = "Do you want delete all conversations?",
              confirmationDialogListener = object : ConfirmationDialogFragment.ConfirmationDialogListener{
                  override fun onAccepted(dialog: DialogFragment) {
                      conversationsAdapter.removeAll()
                      onNoDataFound()
                  }
                  override fun onRejected(dialog: DialogFragment) {}
              }
          )

        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            navigateAndFinish(MainActivity.createDestination(requireActivity()))
        }

        // adding item touch helper
        val itemTouchHelperCallback = SupportItemTouchHelper<Conversation, ConversationsAdapter.ConversationViewHolder>(0, ItemTouchHelper.LEFT, this)
        ItemTouchHelper(itemTouchHelperCallback)
            .attachToRecyclerView(recyclerView)
    }

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Conversation> =
        ConversationsAdapter(requireContext(), picasso, ArrayList()).also {
            conversationsAdapter = it
        }

    override fun onItemClick(item: Conversation) {
        navigate(R.id.action_conversationListFragment_to_conversationMessagesFragment)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
        if (viewHolder is ConversationsAdapter.ConversationViewHolder) {

            val deletedIndex = viewHolder.getAdapterPosition()
            val conversationToDelete =
                conversationsAdapter.getItemByAdapterPosition(deletedIndex)

            // Delete item from adapter
            conversationsAdapter.removeItem(deletedIndex)

            showSnackbar(
                "Conversation was remove",
                Snackbar.LENGTH_LONG,
                "UNDO",
                View.OnClickListener {
                    conversationsAdapter.restoreItem(
                        conversationToDelete,
                        deletedIndex
                    )
                })

        }
    }
}