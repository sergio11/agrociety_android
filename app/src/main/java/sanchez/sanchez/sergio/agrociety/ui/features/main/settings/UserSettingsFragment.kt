package sanchez.sanchez.sergio.agrociety.ui.features.main.settings

import android.os.Bundle
import android.view.View
import com.google.android.material.picker.MaterialDatePicker
import kotlinx.android.synthetic.main.fragment_user_settings.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserSettingsComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.intro.IntroActivity
import sanchez.sanchez.sergio.brownie.extension.navigateAndFinish
import sanchez.sanchez.sergio.brownie.extension.popBackStack
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment



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

        toolbar.setNavigationOnClickListener {
            popBackStack()
        }

        closeSession.setOnClickListener {
            navigateAndFinish(IntroActivity.createDestination(requireActivity()))
        }

        userBirthday.setOnClickListener {

            val builder = MaterialDatePicker.Builder.datePicker()
            builder.setTitleTextResId(R.string.user_settings_birthday_picker_title)
            val picker = builder.build()
            picker.show(childFragmentManager, picker.toString())

        }

    }
}