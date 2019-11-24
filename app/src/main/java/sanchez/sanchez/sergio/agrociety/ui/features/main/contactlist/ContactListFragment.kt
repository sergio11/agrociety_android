package sanchez.sanchez.sergio.agrociety.ui.features.main.contactlist

import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ContactListComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportStickyAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportGroupedLCEFragment

class ContactListFragment: SupportGroupedLCEFragment<Void, User, Void, ContactListViewModel>(ContactListViewModel::class.java) {

    private val component: ContactListComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getContactListComponent(activity as SupportActivity)
    }

    override fun onCreateAdapter(): SupportStickyAdapter<User> =
        ContactListAdapter(requireContext())

    override fun layoutId(): Int =
        R.layout.fragment_contacts_list

    override fun onInject() {
        component.inject(this)
    }

    override fun onItemClick(item: Section<User>) {}

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}
}