package sanchez.sanchez.sergio.agrociety.ui.features.main.postdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject

class PostDetailViewModel @Inject constructor(): SupportViewModel() {

    val like: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun toggleLike() = viewModelScope.launch {
        like.postValue(if(like.value != null)
            !like.value!!
        else
            true
        )
    }
}