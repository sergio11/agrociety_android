package sanchez.sanchez.sergio.agrociety.ui.features.main.home

import android.os.Bundle
import android.view.View
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.HomeComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.CustomBottomNavigationView
import sanchez.sanchez.sergio.agrociety.ui.features.main.components.bottomnav.model.NavItem
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment


class HomeFragment: SupportFragment<HomeViewModel, Void>(HomeViewModel::class.java) {

    private val component: HomeComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getHomeComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_home

    override fun onInject() { component.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CustomBottomNavigationView>(R.id.navigationBottomBar)?.apply {
            savedInstanceState?.let { initWithSaveInstanceState(it) }
            addSpaceItem( NavItem("HOME", R.drawable.ic_home))
            addSpaceItem( NavItem("SEARCH", R.drawable.ic_email))
            addSpaceItem( NavItem("SEARCH", R.drawable.ic_email))
            addSpaceItem( NavItem("SEARCH", R.drawable.ic_profile))
            shouldShowFullBadgeText(true)
            setCentreButtonIconColorFilterEnabled(true)
            showIconOnly()
        }


    }
}