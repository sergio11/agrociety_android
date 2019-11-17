package sanchez.sanchez.sergio.agrociety.ui.features.main.home

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_home.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.HomeComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.conversation.ConversationActivity
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class HomeFragment: SupportFragment<HomeViewModel, Void>(HomeViewModel::class.java) {

    private val component: HomeComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getHomeComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_home

    override fun onInject() { component.inject(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as SupportActivity).apply {
            setSupportActionBar(toolbar)
        }

        personalBoardBlurView.setupWith(parallaxContainer)
            .setFrameClearDrawable(parallaxContainer.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(4.0f)
            .setHasFixedTransformationMatrix(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.conversations)
            navigate(ConversationActivity
                .createDestination(requireActivity()))

        return true
    }

    override fun onStart() {
        super.onStart()
        homeBackground.resume()
    }

    override fun onStop() {
        super.onStop()
        homeBackground.pause()
    }

}