package sanchez.sanchez.sergio.agrociety.ui.features.intro.resetpassword

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_reset_password.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.ResetPasswordComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.extension.popBackStack
import sanchez.sanchez.sergio.brownie.extension.showNoticeDialog
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import sanchez.sanchez.sergio.brownie.ui.dialogs.impl.NoticeDialogFragment

class ResetPasswordFragment: SupportFragment<ResetPasswordViewModel, Void>(
    ResetPasswordViewModel::class.java)  {

    private val resetPasswordComponent: ResetPasswordComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getResetPasswordComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_reset_password

    override fun onInject() { resetPasswordComponent.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sendButton.setOnClickListener {
            showNoticeDialog(
                stringResId = R.string.reset_password_check_email,
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