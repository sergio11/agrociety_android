package sanchez.sanchez.sergio.agrociety.ui.features.intro.location

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_set_location.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SetLocationComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.main.MainActivity
import sanchez.sanchez.sergio.brownie.extension.navigateAndFinish
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class SetLocationFragment: SupportFragment<SetLocationViewModel, Void>(
    SetLocationViewModel::class.java) {

    private val component: SetLocationComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSetLocationComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_set_location

    override fun onInject() { component.inject(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        permissionManager.setCheckPermissionListener(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainTitle.text = String.format(getString(R.string.set_location_main_title), "Sergio")

        turnGps.setOnClickListener { onTurnOnGps() }

    }

    /**
     * Private Methods
     */

    private fun onTurnOnGps() {
        permissionManager.checkSinglePermission(ACCESS_FINE_LOCATION, getString(R.string.set_location_reason_text))
    }

    override fun onSinglePermissionGranted(permission: String) {
        super.onSinglePermissionGranted(permission)

        navigateAndFinish(MainActivity.createDestination(requireActivity()))
    }

    override fun onSinglePermissionRejected(permission: String) {
        super.onSinglePermissionRejected(permission)

        navigateAndFinish(MainActivity.createDestination(requireActivity()))

    }

    override fun onErrorOccurred(permission: String) {
        super.onErrorOccurred(permission)

        navigateAndFinish(MainActivity.createDestination(requireActivity()))
    }
}