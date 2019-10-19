package sanchez.sanchez.sergio.agrociety.ui.features.login

import android.os.Bundle
import android.view.View
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_login.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.LoginComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class LoginFragment : SupportFragment<LoginViewModel, Void>(LoginViewModel::class.java) {

    private val TAG = "LOGIN"

    private val loginComponent: LoginComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getLoginComponent(activity as SupportActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginContainerBlurView.setupWith(container)
            .setFrameClearDrawable(container.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(4.0f)
            .setHasFixedTransformationMatrix(true)
    }

    override fun onStart() {
        super.onStart()
        screenBackground.resume()
    }

    override fun onStop() {
        super.onStop()
        screenBackground.pause()
    }

    override fun layoutId(): Int = R.layout.fragment_login

    override fun onInject() { loginComponent.inject(this) }

}
