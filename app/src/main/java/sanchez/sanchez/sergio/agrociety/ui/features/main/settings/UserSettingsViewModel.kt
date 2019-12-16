package sanchez.sanchez.sergio.agrociety.ui.features.main.settings

import androidx.lifecycle.MutableLiveData
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject


enum class PhotoTypeEnum {
    PRIMARY,
    SECONDARY
}

class UserSettingsViewModel @Inject constructor(): SupportViewModel() {

    val photoCurrentlyEditing: MutableLiveData<PhotoTypeEnum> by lazy {
        MutableLiveData<PhotoTypeEnum>()
    }

}