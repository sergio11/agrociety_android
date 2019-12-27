package sanchez.sanchez.sergio.agrociety.ui.features.main.search.tags

import sanchez.sanchez.sergio.agrociety.domain.model.CategoryTag
import sanchez.sanchez.sergio.brownie.ui.core.viewmodel.SupportLCEViewModel
import javax.inject.Inject

class SearchCategoryTagsViewModel @Inject constructor(): SupportLCEViewModel<CategoryTag, SearchCategoryTagsArg>() {

    private val categoryTags = mutableListOf(
        CategoryTag(
            id = "fdshfdsk4732432",
            name = "TAG 1"
        ),
        CategoryTag(
            id = "dsafdsfds432432",
            name = "TAG 2"
        ),
        CategoryTag(
            id = "dsfsdfdsfds43534",
            name = "TAG 3"
        ),
        CategoryTag(
            id = "sdsadsadas43543534",
            name = "TAG 4"
        ),
        CategoryTag(
            id = "fdsfdsfsdfsd54645",
            name = "TAG 5"
        ),
        CategoryTag(
            id = "fdsfsdf45353453453",
            name = "TAG 6"
        ),
        CategoryTag(
            id = "sdfdsfdsfsdf453534534",
            name = "TAG 7"
        )
    )

    override suspend fun onLoadData(): List<CategoryTag> =
        categoryTags

    override suspend fun onLoadData(params: SearchCategoryTagsArg): List<CategoryTag> =
        categoryTags


}