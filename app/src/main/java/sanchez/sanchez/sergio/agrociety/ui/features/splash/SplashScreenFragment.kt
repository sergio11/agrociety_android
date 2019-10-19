package sanchez.sanchez.sergio.agrociety.ui.features.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_splash_screen.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SplashScreenComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import timber.log.Timber


class SplashScreenFragment : SupportFragment<SplashViewModel, Void>(SplashViewModel::class.java) {

    private val TAG = "SPLASH_S"


    private val splashScreenComponent: SplashScreenComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSplashScreenComponent(activity as SupportActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.result.observe(this, Observer{

            if(it == SplashOperationResultEnum.USER_LOADED)
                onSessionLoaded()
            else
                onSessionNotAvaliable()

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layerBlurView.setupWith(container)
            .setFrameClearDrawable(container.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(8.0f)
            .setHasFixedTransformationMatrix(true)
    }

    override fun onStart() {
        super.onStart()
        viewModel.loadSession()
    }

    override fun layoutId(): Int = R.layout.fragment_splash_screen

    override fun onInject() { splashScreenComponent.inject(this) }

    /**
     * Private Methods
     */

    private fun onSessionLoaded() {
        Timber.tag(TAG).d("On Session Loaded")
    }

    private fun onSessionNotAvaliable() {
        Timber.tag(TAG).d("On Session Not Avaliable")
    }

}
