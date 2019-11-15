package sanchez.sanchez.sergio.agrociety.ui.features.main.profile

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserProfileComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

/**
 * User Profile Fragment
 */
class UserProfileFragment: SupportFragment<UserProfileViewModel, Void>(UserProfileViewModel::class.java) {

    private val component: UserProfileComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getUserProfileComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_user_profile

    override fun onInject() { component.inject(this) }
}