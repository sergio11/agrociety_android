package sanchez.sanchez.sergio.agrociety.ui.features.main.userdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject

class UserDetailViewModel @Inject constructor(): SupportViewModel() {


    val follow: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val userDetail: MutableLiveData<User> by lazy {
        MutableLiveData<User>()
    }

    /**
     * Load User by id
     * @param userId
     */
    fun load(userId: String) = viewModelScope.launch {
        userDetail.postValue(User(
            id = "dsadsadsadsadas",
            displayName = "David Martín Fidalgo",
            email = "davidmartin@gmail.com",
            follow = 23,
            followers = 13,
            photoUrl = "https://media.licdn.com/dms/image/C5603AQFHfMzxZg-B1Q/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=s1HgcSfcUNKYizZwFyrCyp30YzJuFsErYrOd_uY9XXM",
            background = R.drawable.publication_example_one
        ))
    }

    fun toogleFollow() = viewModelScope.launch {
        if(follow.value == true)
            follow.postValue(false)
        else
            follow.postValue(true)
    }


}