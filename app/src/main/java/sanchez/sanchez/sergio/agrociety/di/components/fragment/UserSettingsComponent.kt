package sanchez.sanchez.sergio.agrociety.di.components.fragment

import dagger.Subcomponent
import sanchez.sanchez.sergio.agrociety.di.modules.viewmodel.UserSettingsModule
import sanchez.sanchez.sergio.agrociety.ui.features.main.settings.ChangePhotoMenuBottomSheet
import sanchez.sanchez.sergio.agrociety.ui.features.main.settings.UserSettingsFragment
import sanchez.sanchez.sergio.brownie.di.components.FragmentComponent
import sanchez.sanchez.sergio.brownie.di.scopes.PerFragment

@PerFragment
@Subcomponent(
    modules = [
        UserSettingsModule::class ])
interface UserSettingsComponent: FragmentComponent {

    fun inject(userSettingsFragment: UserSettingsFragment)
    fun inject(changePhotoMenuBottomSheet: ChangePhotoMenuBottomSheet)
}