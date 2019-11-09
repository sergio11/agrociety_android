package sanchez.sanchez.sergio.agrociety.ui.features.main.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.HomeComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.CustomBottomNavigationView
import sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.listener.ISpaceOnClickListener
import sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.listener.ISpaceOnLongClickListener
import sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.model.NavItem
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import timber.log.Timber


class HomeFragment: SupportFragment<HomeViewModel, Void>(HomeViewModel::class.java) {

    private val component: HomeComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getHomeComponent(activity as SupportActivity)
    }

    private var bottomNavigationView: CustomBottomNavigationView? = null

    override fun layoutId(): Int = R.layout.fragment_home

    override fun onInject() { component.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView = view.findViewById<CustomBottomNavigationView>(R.id.navigationBottomBar)?.apply {
            savedInstanceState?.let { initWithSaveInstanceState(it) }
            addSpaceItem( NavItem("HOME", R.drawable.ic_home))
            addSpaceItem( NavItem("SEARCH", R.drawable.ic_search))
            addSpaceItem( NavItem("LIKE", R.drawable.ic_like))
            addSpaceItem( NavItem("PROFILE", R.drawable.ic_profile))
            shouldShowFullBadgeText(true)
            setCentreButtonIconColorFilterEnabled(true)
            setSpaceOnClickListener(spaceOnClickListener)
            setSpaceOnLongClickListener(spaceOnLongClickListener)
        }
    }


    private val spaceOnClickListener = object : ISpaceOnClickListener {
        override fun onCentreButtonClick() {
            Timber.d("On Centre Button Click Listener")
            bottomNavigationView?.showBadgeAtIndex(
                itemIndex = 2,
                badgeText = 9,
                badgeColor = ContextCompat.getColor(
                    requireContext(), R.color.redDanger
                )
            )
        }

        override fun onItemClick(itemIndex: Int, itemName: String) {
            Timber.d("On Item $itemName clicked")
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
}