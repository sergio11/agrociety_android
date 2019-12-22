package sanchez.sanchez.sergio.agrociety.ui.features.main.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory

class SearchPagerAdapter(private val categories: List<SearchCategory>, fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {

    override fun getItem(position: Int): Fragment =
        SearchByCategoryFragment.newInstance(categories[position])

    override fun getPageTitle(position: Int): CharSequence? =
        categories[position].title

    override fun getCount(): Int = categories.size
}