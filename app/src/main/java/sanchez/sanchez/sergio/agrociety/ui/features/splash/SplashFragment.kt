package sanchez.sanchez.sergio.agrociety.ui.features.splash

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.lifecycle.Observer
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.activity_intro.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SplashComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.home.HomeActivity
import sanchez.sanchez.sergio.agrociety.ui.features.intro.IntroActivity
import sanchez.sanchez.sergio.brownie.extension.navigateAndFinish
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class SplashFragment: SupportFragment<SplashViewModel, Void>(SplashViewModel::class.java) {

    private val component: SplashComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSplashComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_splash_screen

    override fun onInject() { component.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        containerBlurView.setupWith(container)
            .setFrameClearDrawable(container.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(4.0f)
            .setHasFixedTransformationMatrix(true)


        viewModel.result.observe(this, Observer {
            when(it) {
                SplashResultEnum.SESSION_LOADED -> onSessionLoaded()
                SplashResultEnum.SESSION_NOT_FOUND -> onSessionNotLoaded()
                else -> onSessionNotLoaded()
            }
        })

        Handler().postDelayed(fun() {
            viewModel.loadSession()
        }, 1000)

    }

    /**
     * Private Methods
     */

    private fun onSessionLoaded() {
        navigateAndFinish(HomeActivity.createDestination(requireActivity()))
    }

    private fun onSessionNotLoaded() {
        navigateAndFinish(IntroActivity.createDestination(requireActivity()))
    }
}