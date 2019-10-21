package sanchez.sanchez.sergio.agrociety.ui.features.signup

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_signup.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SignupComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.extension.popBackStack
import sanchez.sanchez.sergio.brownie.extension.showNoticeDialog
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import sanchez.sanchez.sergio.brownie.ui.dialogs.impl.NoticeDialogFragment

class SignupFragment: SupportFragment<SignupViewModel, Void>(SignupViewModel::class.java) {

    private val signupComponent: SignupComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSignupComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_signup

    override fun onInject() { signupComponent.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToLogin.setOnClickListener {
            popBackStack()
        }

        registerButton.setOnClickListener {
            showNoticeDialog(
                stringResId = R.string.signup_check_email,
                isSuccess = true,
                noticeDialogListener = object : NoticeDialogFragment.NoticeDialogListener {
                    override fun onAccepted(dialog: DialogFragment) {
                        popBackStack()
                    }
                }
            )
        }
    }
}