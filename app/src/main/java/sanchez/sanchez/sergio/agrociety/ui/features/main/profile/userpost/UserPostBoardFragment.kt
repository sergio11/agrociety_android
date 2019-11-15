package sanchez.sanchez.sergio.agrociety.ui.features.main.profile.userpost

import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserPostBoardComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class UserPostBoardFragment: SupportFragment<UserPostBoardViewModel, Void>(UserPostBoardViewModel::class.java) {

    private val component: UserPostBoardComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getUserPostBoardComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int =
        R.layout.fragment_user_post_board

    override fun onInject() {
        component.inject(this)
    }
}