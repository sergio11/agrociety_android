package sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.user

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SearchComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.SearchFragmentDirections
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.models.Section
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportGroupedRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportGroupedLCEFragment
import javax.inject.Inject

class SearchUserFragment: SupportGroupedLCEFragment<Void, User, Void, SearchUserViewModel>(SearchUserViewModel::class.java) {

    private val component: SearchComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSearchComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun onCreateAdapter(): SupportGroupedRecyclerViewAdapter<User> =
        SearchUserAdapter(requireContext(), picasso)

    override fun layoutId(): Int = R.layout.fragment_search_user_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onItemClick(item: Section<User>) {
        navigate(SearchFragmentDirections.actionGlobalUserDetailFragment(item.element()))
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}
}