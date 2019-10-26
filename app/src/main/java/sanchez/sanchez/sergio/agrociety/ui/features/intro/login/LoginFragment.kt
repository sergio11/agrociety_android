package sanchez.sanchez.sergio.agrociety.ui.features.intro.login

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_login.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.LoginComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.home.HomeActivity
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.extension.navigateAndFinish
import sanchez.sanchez.sergio.brownie.extension.showNoticeDialog
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import sanchez.sanchez.sergio.brownie.ui.dialogs.impl.NoticeDialogFragment
import timber.log.Timber

class LoginFragment : SupportFragment<LoginViewModel, Void>(
    LoginViewModel::class.java) {

    private val TAG = "LOGIN"

    private val loginComponent: LoginComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getLoginComponent(activity as SupportActivity)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        forgotPassword.setOnClickListener {
            navigate(R.id.action_loginFragment_to_resetPasswordFragment)
        }

        createNewAccount.setOnClickListener {
            navigate(R.id.action_loginFragment_to_signupFragment)
        }

        loginButton.setOnClickListener { onLogin() }

    }


    override fun layoutId(): Int = R.layout.fragment_login

    override fun onInject() { loginComponent.inject(this) }


    /**
     * Private Methods
     */

    private fun onLogin(){

        val email = emailInput.text.toString()
        val password = passwordInput.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty())
            if(permissionManager.shouldAskPermission(ACCESS_FINE_LOCATION))
                navigate(R.id.action_loginFragment_to_setLocationFragment)
            else
                navigateAndFinish(HomeActivity.createDestination(requireActivity()))
        else
            showNoticeDialog(
                stringResId = R.string.login_user_or_password_incorrect,
                isSuccess = true,
                noticeDialogListener = object : NoticeDialogFragment.NoticeDialogListener {
                    override fun onAccepted(dialog: DialogFragment) {

                    }
                }
            )
    }

}
