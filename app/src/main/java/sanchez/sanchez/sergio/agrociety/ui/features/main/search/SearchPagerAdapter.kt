package sanchez.sanchez.sergio.agrociety.ui.features.main.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategoryTypeEnum
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.announcements.SearchAnnouncementsFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.event.SearchEventFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.post.SearchPostFragment
import sanchez.sanchez.sergio.agrociety.ui.features.main.search.categories.user.SearchUserFragment

class SearchPagerAdapter(private val categories: List<SearchCategory>, fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment =
        when(categories[position].type) {
            SearchCategoryTypeEnum.POSTS ->
                SearchPostFragment.newInstance(categories[position])
            SearchCategoryTypeEnum.USERS ->
                SearchUserFragment.newInstance(categories[position])
            SearchCategoryTypeEnum.EVENTS ->
                SearchEventFragment.newInstance(categories[position])
            SearchCategoryTypeEnum.ANNOUNCEMENTS ->
                SearchAnnouncementsFragment.newInstance(categories[position])
        }

    override fun getPageTitle(position: Int): CharSequence? =
        categories[position].title

    override fun getCount(): Int = categories.size
}