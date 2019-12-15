package sanchez.sanchez.sergio.agrociety.ui.features.main.settings

import android.Manifest
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.google.android.material.picker.MaterialDatePicker
import kotlinx.android.synthetic.main.fragment_user_settings.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserSettingsComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.intro.IntroActivity
import sanchez.sanchez.sergio.brownie.extension.*
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import timber.log.Timber

class UserSettingsFragment: SupportFragment<UserSettingsViewModel, Void>(UserSettingsViewModel::class.java) {

    private val component: UserSettingsComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getUserSettingsComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int =
        R.layout.fragment_user_settings

    override fun onInject() {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.apply {
            setNavigationOnClickListener {
                popBackStack()
            }
            setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.saveChanges ->
                        onSaveChanges()
                }
                true
            }
        }



        closeSession.setOnClickListener {
            navigateAndFinish(IntroActivity.createDestination(requireActivity()))
        }

        userBirthday.setOnClickListener {

            val picker = MaterialDatePicker.Builder.datePicker().apply {
                setTitleTextResId(R.string.user_settings_birthday_picker_title)
            }.build()

            picker.addOnDismissListener {
                picker.selection?.let { currentSelection ->
                    userBirthday.setText(currentSelection.toDateStringWithAge(requireContext()))
                }
            }
            picker.show(childFragmentManager, picker.toString())

        }

        changePrimaryPhoto.setOnClickListener {
            onChangePhoto()
        }

        changeSecondaryPhoto.setOnClickListener {
            onChangePhoto()
        }
    }


    override fun onSinglePermissionGranted(permission: String) {
        super.onSinglePermissionGranted(permission)
        Timber.d("onSinglePermissionGranted -> $permission")
    }

    override fun onSinglePermissionRejected(permission: String) {
        super.onSinglePermissionRejected(permission)
        Timber.d("onSinglePermissionRejected -> $permission")
    }

    override fun onErrorOccurred(permission: String) {
        super.onErrorOccurred(permission)
        Timber.d("onErrorOccurred -> $permission")
    }

    /**
     * Private Methods
     */

    private fun onSaveChanges() {
        showProgressDialog(R.string.progress_please_wait)
        Handler().postDelayed({
            hideProgressDialog()
            showNoticeDialog(R.string.user_settings_profile_saved_successful, true)
        }, 2000)
    }

    /**
     * On Change Photo
     */
    private fun onChangePhoto() {
        if(permissionManager.shouldAskPermission(Manifest.permission.CAMERA)) {
            permissionManager.checkSinglePermission(
                permission = Manifest.permission.CAMERA,
                reasonText = "")
        }
    }

}