package sanchez.sanchez.sergio.agrociety.ui.features.main.contactlist

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_contacts_list.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ContactListComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.extension.popBackStack
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportGroupedRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportGroupedLCEFragment
import javax.inject.Inject

class ContactListFragment: SupportGroupedLCEFragment<Void, User, Void, ContactListViewModel>(ContactListViewModel::class.java) {

    private val component: ContactListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getContactListComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun onCreateAdapter(): SupportGroupedRecyclerViewAdapter<User> =
        ContactListAdapter(requireContext(), picasso)

    override fun layoutId(): Int =
        R.layout.fragment_contacts_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contactListFollowers.setNavigationOnClickListener {
            popBackStack()
        }
    }

    override fun onItemClick(item: Section<User>) {}

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}
}