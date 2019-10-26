package sanchez.sanchez.sergio.agrociety.ui.features.home

import android.app.Activity
import androidx.navigation.ActivityNavigator
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.activity.HomeActivityComponent
import sanchez.sanchez.sergio.agrociety.di.components.activity.IntroActivityComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.extension.createDestination
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity


class HomeActivity: SupportActivity() {

    private val activityComponent: HomeActivityComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getHomeActivityComponent(this)
    }

    override fun layoutId(): Int = R.layout.activity_home

    override fun navHostId(): Int = R.id.navHostContainer

    override fun onInject() { activityComponent.inject(this) }


    /** COMPANION OBJECT **/

    companion object {

        @JvmStatic
        fun createDestination(activity: Activity): ActivityNavigator.Destination =
            activity.createDestination(HomeActivity::class.java)

    }


}