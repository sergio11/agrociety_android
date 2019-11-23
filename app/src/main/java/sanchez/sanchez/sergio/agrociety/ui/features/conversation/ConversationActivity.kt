package sanchez.sanchez.sergio.agrociety.ui.features.conversation

import android.app.Activity
import androidx.navigation.ActivityNavigator
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.activity.ConversationActivityComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.extension.createDestination
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity

class ConversationActivity: SupportActivity() {

    private val activityComponent: ConversationActivityComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getConversationActivityComponent(this)
    }

    override fun layoutId(): Int = R.layout.activity_conversation

    override fun navHostId(): Int = R.id.navHostContainer

    override fun onInject() {
        activityComponent.inject(this)
    }

    companion object {

        @JvmStatic
        fun createDestination(activity: Activity): ActivityNavigator.Destination =
            activity.createDestination(ConversationActivity::class.java)
    }


}