package sanchez.sanchez.sergio.agrociety.ui.features.intro.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SplashScreenComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.extension.navigate
import timber.log.Timber


class SplashScreenFragment : SupportFragment<SplashViewModel, Void>(
    SplashViewModel::class.java) {

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
        navigate(R.id.action_splashScreenFragment_to_loginFragment)
    }

    private fun onSessionNotAvaliable() {
        Timber.tag(TAG).d("On Session Not Avaliable")
        navigate(R.id.action_splashScreenFragment_to_loginFragment)
    }

}
