package sanchez.sanchez.sergio.agrociety.ui.features.main.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sanchez.sanchez.sergio.agrociety.domain.model.CategoryTag
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategoryTypeEnum
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportViewModel
import javax.inject.Inject

class SearchViewModel @Inject constructor(): SupportViewModel() {

    val categories: MutableLiveData<MutableList<SearchCategory>> by lazy {
        MutableLiveData<MutableList<SearchCategory>>()
    }

    val tags: MutableLiveData<MutableList<CategoryTag>> by lazy {
        MutableLiveData<MutableList<CategoryTag>>()
    }

    /**
     * Load Categories
     */
    fun loadCategories() = viewModelScope.launch {
        categories.postValue(mutableListOf(
            SearchCategory(
                id = "43242hfjksdhfjksd",
                title = "Posts",
                type = SearchCategoryTypeEnum.POSTS
            ),
            SearchCategory(
                id = "fdfds4324324",
                title = "Users",
                type = SearchCategoryTypeEnum.USERS
            ),
            SearchCategory(
                id = "43242hfjksdhfjksd",
                title = "Events",
                type = SearchCategoryTypeEnum.EVENTS
            ),
            SearchCategory(
                id = "43242hfjksdhfjksd",
                title = "Announcements",
                type = SearchCategoryTypeEnum.ANNOUNCEMENTS
            )
        ))

    }

    /**
     * Load Tags by category
     * @param category
     */
    fun loadTagsByCategory(category: String) = viewModelScope.launch {
        tags.postValue(mutableListOf(
            CategoryTag(
                id = "fdsjfkldsh",
                name = "Tag 1"
            ),
            CategoryTag(
                id = "ewqeqw43234",
                name = "Tag 2"
            ),
            CategoryTag(
                id = "fdsfsd54324324",
                name = "Tag 3"
            ),
            CategoryTag(
                id = "asdsadsa432432",
                name = "Tag 4"
            ),
            CategoryTag(
                id = "fdsfds43423432",
                name = "Tag 5"
            )
        ))
    }

}