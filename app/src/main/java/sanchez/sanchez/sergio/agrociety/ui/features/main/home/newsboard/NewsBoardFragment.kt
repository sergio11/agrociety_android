package sanchez.sanchez.sergio.agrociety.ui.features.main.home.newsboard

import androidx.recyclerview.widget.RecyclerView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.NewsBoardComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Publication
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import timber.log.Timber

/**
 * News Board Fragment
 */
class NewsBoardFragment: SupportLCEFragment<Void, Publication, Void, NewsBoardViewModel>(NewsBoardViewModel::class.java) {

    private val component: NewsBoardComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getNewsBoardComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_news_board

    override fun onInject() { component.inject(this)}

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Publication> =
        NewsBoardAdapter(requireContext(), ArrayList())

    override fun onItemClick(item: Publication) { Timber.d("On Item Clicked") }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) { Timber.d("On Swiped") }
}