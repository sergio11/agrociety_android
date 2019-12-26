package sanchez.sanchez.sergio.agrociety.ui.features.main.search

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import com.ToxicBakery.viewpager.transforms.ZoomInTransformer
import kotlinx.android.synthetic.main.fragment_search_layout.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SearchComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.brownie.extension.popBackStack
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import timber.log.Timber


class SearchFragment: SupportFragment<SearchViewModel, Void>(SearchViewModel::class.java) {

    private val TAG = "SEARCH_FRAG"

    private val component: SearchComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSearchComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int =
        R.layout.fragment_search_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel.categories.observe(this, Observer {
            onCategoriesLoaded(it)
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setNavigationOnClickListener {
            popBackStack()
        }

        configureSearchView()

        viewModel.loadCategories()
    }


    /**
     * Private Methods
     */

    private fun onCategoriesLoaded(categories: MutableList<SearchCategory>) {
        viewPager.apply {
            adapter = SearchPagerAdapter(categories, childFragmentManager,
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
            setPageTransformer(true, ZoomInTransformer())
        }
        tabs.setupWithViewPager(viewPager)
    }


    private fun onSearchSubmit(query: String) {
        Timber.d("onSearchSubmit -> query: $query")
    }

    private fun configureSearchView() {

        toolbar.menu.findItem(R.id.searchData).apply {
            // Assign the listener to that action item
            setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
                override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                    requireActivity().supportFragmentManager.popBackStack()
                    // Do something when action item collapses
                    return true  // Return true to collapse action view
                }

                override fun onMenuItemActionExpand(item: MenuItem): Boolean {

                    // Do something when expanded
                    return true  // Return true to expand action view
                }
            })

            (actionView as SearchView).apply {
                expandActionView() // when fragment opens it expanded auto
                setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String): Boolean {
                        onSearchSubmit(query)
                        return true
                    }
                    override fun onQueryTextChange(newText: String): Boolean {
                        return false
                    }
                })
            }

        }

    }

}