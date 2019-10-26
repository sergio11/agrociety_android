package sanchez.sanchez.sergio.agrociety.ui.features.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject


class SplashViewModel @Inject constructor(): SupportViewModel() {

    val result: MutableLiveData<SplashResultEnum> by lazy {
        MutableLiveData<SplashResultEnum>()
    }

    fun loadSession() = viewModelScope.launch {

        result.postValue(SplashResultEnum.SESSION_NOT_FOUND)

    }


}