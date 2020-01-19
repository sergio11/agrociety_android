package sanchez.sanchez.sergio.agrociety.ui.features.main

import android.app.Activity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.navigation.ActivityNavigator
import androidx.navigation.NavController
import kotlinx.android.synthetic.main.activity_main.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.activity.MainActivityComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.intro.IntroActivity
import sanchez.sanchez.sergio.brownie.extension.*
import sanchez.sanchez.sergio.brownie.ui.components.bottomnav.listener.ISpaceOnClickListener
import sanchez.sanchez.sergio.brownie.ui.components.bottomnav.listener.ISpaceOnLongClickListener
import sanchez.sanchez.sergio.brownie.ui.components.bottomnav.model.NavItem
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.dialogs.impl.ConfirmationDialogFragment
import timber.log.Timber


class MainActivity: SupportActivity() {

    private val activityComponent: MainActivityComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getMainActivityComponent(this)
    }

    override fun layoutId(): Int = R.layout.activity_main

    override fun navHostId(): Int = R.id.navHostContainer

    override fun onInject() { activityComponent.inject(this) }

    override fun onSetupNavigation(savedInstanceState: Bundle?, navController: NavController?) {
        super.onSetupNavigation(savedInstanceState, navController)

        navigationBottomBar?.apply {
            savedInstanceState?.let { initWithSaveInstanceState(it) }
            addSpaceItem(
                NavItem(
                    itemName = getString(R.string.main_navigation_home_item),
                    itemIcon = R.drawable.ic_home)
            )
            addSpaceItem(
                NavItem(
                    itemName = getString(R.string.main_navigation_home_item),
                    itemIcon = R.drawable.ic_home)
            )
            addSpaceItem(
                NavItem(
                    itemName = getString(R.string.main_navigation_events_item),
                    itemIcon = R.drawable.ic_event_menu)
            )
            addSpaceItem(
                NavItem(
                    itemName = getString(R.string.main_navigation_profile_item),
                    itemIcon = R.drawable.ic_profile)
            )
            shouldShowFullBadgeText(true)
            setCentreButtonIconColorFilterEnabled(true)
            setSpaceOnClickListener(spaceOnClickListener)
            setSpaceOnLongClickListener(spaceOnLongClickListener)
        }


        navController?.let {
            it.addOnDestinationChangedListener { controller, destination, arguments ->
                when(destination.id) {
                    R.id.homeFragment ->
                        navigationBottomBar?.apply {
                            visible()
                            updateSpaceItems(HOME_MENU_ITEM_IDX)
                        }
                    R.id.userProfileFragment ->
                        navigationBottomBar?.apply {
                            visible()
                            updateSpaceItems(PROFILE_MENU_ITEM_IDX)
                        }
                    R.id.eventsFragment ->
                        navigationBottomBar?.apply {
                            visible()
                            updateSpaceItems(EVENTS_MENU_ITEM_IDX)
                        }
                    else -> {
                        navigationBottomBar?.gone()
                    }
                }
            }

        }

    }

    private val spaceOnClickListener = object : ISpaceOnClickListener {
        override fun onCentreButtonClick() {
            Timber.d("On Centre Button Click Listener")
            navigationBottomBar?.showBadgeAtIndex(
                itemIndex = 2,
                badgeText = 9,
                badgeColor = ContextCompat.getColor(
                    baseContext, R.color.redDanger
                )
            )
        }

        override fun onItemClick(itemIndex: Int, itemName: String) {
            Timber.d("On Item $itemName clicked")
            when(itemIndex) {
                HOME_MENU_ITEM_IDX ->
                    if(navController?.currentDestination?.id != R.id.homeFragment)
                        navigate(R.id.homeFragment)
                SERVICES_MENU_ITEM_IDX ->
                    if(navController?.currentDestination?.id != R.id.homeFragment)
                        navigate(R.id.homeFragment)
                EVENTS_MENU_ITEM_IDX ->
                    if(navController?.currentDestination?.id != R.id.eventsFragment)
                        navigate(R.id.eventsFragment)
                PROFILE_MENU_ITEM_IDX ->
                    if(navController?.currentDestination?.id != R.id.userProfileFragment)
                        navigate(R.id.userProfileFragment)
                }
        }

        override fun onItemReselected(itemIndex: Int, itemName: String) {
            Timber.d("On Item $itemName Reselected")
        }
    }

    private val spaceOnLongClickListener = object : ISpaceOnLongClickListener {
        override fun onCentreButtonLongClick() {
            Timber.d("onCentreButtonLongClick")
        }
        override fun onItemLongClick(itemIndex: Int, itemName: String) {
            Timber.d("On Item $itemName long clicked")
        }
    }

    override fun onBackPressed() {
        if(navController?.currentDestination?.id == R.id.homeFragment)
            showConfirmationDialog(R.string.confirm_close_session, object : ConfirmationDialogFragment.ConfirmationDialogListener {
                override fun onAccepted(dialog: DialogFragment) {
                    navigateAndFinish(IntroActivity.createDestination(this@MainActivity))
                }
                override fun onRejected(dialog: DialogFragment) {}
            })
        else
            super.onBackPressed()

    }

    /** COMPANION OBJECT **/

    companion object {

        const val HOME_MENU_ITEM_IDX = 0
        const val SERVICES_MENU_ITEM_IDX = 1
        const val EVENTS_MENU_ITEM_IDX = 2
        const val PROFILE_MENU_ITEM_IDX = 3


        @JvmStatic
        fun createDestination(activity: Activity): ActivityNavigator.Destination =
            activity.createDestination(MainActivity::class.java)

    }


}