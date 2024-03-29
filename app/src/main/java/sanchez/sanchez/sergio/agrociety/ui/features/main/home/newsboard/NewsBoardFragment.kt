package sanchez.sanchez.sergio.agrociety.ui.features.main.home.newsboard

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.NewsBoardComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.HomeFragmentDirections
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.extension.shareSimpleContent
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import timber.log.Timber
import javax.inject.Inject

/**
 * News Board Fragment
 */
class NewsBoardFragment: SupportLCEFragment<Void, Post, Void, NewsBoardViewModel>(
    NewsBoardViewModel::class.java), NewsBoardAdapter.OnNewsBoardListener {


    private val component: NewsBoardComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getNewsBoardComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun layoutId(): Int = R.layout.fragment_news_board

    override fun onInject() { component.inject(this)}

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Post> =
        NewsBoardAdapter(picasso, requireContext(), ArrayList()).also {
            it.listener = this
        }

    override fun onItemClick(item: Post) {
        navigate(HomeFragmentDirections.actionGlobalPostDetailFragment(item))
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) { Timber.d("On Swiped") }

    override fun onGoToUserDetail(user: User) {
        navigate(HomeFragmentDirections.actionGlobalUserDetailFragment(user))
    }

    override fun onSharePublication(post: Post) {
        requireActivity().shareSimpleContent(
            textTitle = "${post.title} - ${post.subtitle}",
            textContent = "Contenido de la aplicación, ver más en Agrociety"
        )
    }
}