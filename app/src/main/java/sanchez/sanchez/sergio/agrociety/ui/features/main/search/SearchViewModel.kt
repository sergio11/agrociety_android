package sanchez.sanchez.sergio.agrociety.ui.features.main.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject

class SearchViewModel @Inject constructor(): SupportViewModel() {

    val categories: MutableLiveData<MutableList<SearchCategory>> by lazy {
        MutableLiveData<MutableList<SearchCategory>>()
    }

    /**
     * Load Categories
     */
    fun loadCategories() = viewModelScope.launch {
        categories.postValue(mutableListOf(
            SearchCategory(
                id = "43242hfjksdhfjksd",
                title = "Posts"
            ),
            SearchCategory(
                id = "fdfds4324324",
                title = "Users"
            ),
            SearchCategory(
                id = "43242hfjksdhfjksd",
                title = "Events"
            ),
            SearchCategory(
                id = "43242hfjksdhfjksd",
                title = "Announcements"
            )
        ))

    }

}