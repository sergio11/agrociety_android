package sanchez.sanchez.sergio.agrociety.ui.features.intro.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(
): SupportViewModel() {

    val result: MutableLiveData<SplashOperationResultEnum> by lazy {
        MutableLiveData<SplashOperationResultEnum>()
    }

    fun loadSession() = viewModelScope.launch {
        try {
            result.postValue(SplashOperationResultEnum.USER_LOADED)
        } catch (ex: Exception) {
            result.postValue(SplashOperationResultEnum.USER_NOT_AVAILABLE)
        }
    }

}