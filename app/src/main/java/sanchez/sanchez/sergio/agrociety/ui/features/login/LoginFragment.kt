package sanchez.sanchez.sergio.agrociety.ui.features.login

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_login.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.LoginComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.extension.navigate
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

        forgotPassword.setOnClickListener {
            navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }
    }


    override fun layoutId(): Int = R.layout.fragment_login

    override fun onInject() { loginComponent.inject(this) }

}
