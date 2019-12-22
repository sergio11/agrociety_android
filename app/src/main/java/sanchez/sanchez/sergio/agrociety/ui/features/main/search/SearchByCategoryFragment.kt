package sanchez.sanchez.sergio.agrociety.ui.features.main.search

import android.os.Bundle
import android.view.View
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.SearchComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.SearchCategory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class SearchByCategoryFragment: SupportFragment<SearchViewModel, Void>(SearchViewModel::class.java) {

    private val component: SearchComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getSearchComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int =
        R.layout.fragment_search_by_category_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchCategory = requireArguments().getParcelable<SearchCategory>(CATEGORY_KEY)



    }

    companion object {

        private const val CATEGORY_KEY = "CATEGORY_KEY"

        @JvmStatic
        fun newInstance(searchCategory: SearchCategory) = SearchByCategoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY_KEY, searchCategory)
            }
        }

    }
}