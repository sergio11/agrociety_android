package sanchez.sanchez.sergio.agrociety.ui.features.home.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.container
import kotlinx.android.synthetic.main.fragment_main.containerBlurView
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.MainComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment



class MainFragment: SupportFragment<MainViewModel, Void>(MainViewModel::class.java) {

    private val component: MainComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getMainComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_main

    override fun onInject() { component.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById(R.id.toolbar) as Toolbar


        containerBlurView.setupWith(diagonalLayout)
            .setFrameClearDrawable(diagonalLayout.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(1.0f)
            .setHasFixedTransformationMatrix(true)

    }
}