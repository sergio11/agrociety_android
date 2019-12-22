package sanchez.sanchez.sergio.agrociety.ui.features.main.common.userpost

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_user_post_board.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserPostBoardComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Publication
import sanchez.sanchez.sergio.agrociety.ui.features.main.common.CommonPublicationAdapter
import sanchez.sanchez.sergio.agrociety.ui.features.main.common.CommonSimplePublicationAdapter
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment

class UserPostBoardFragment: SupportLCEFragment<Void, Publication, Void, UserPostBoardViewModel>(UserPostBoardViewModel::class.java) {

    private val component: UserPostBoardComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getUserPostBoardComponent(activity as SupportActivity)
    }

    private var dataMode: DataModeEnum = DataModeEnum.GRID

    override fun layoutId(): Int = R.layout.fragment_user_post_board

    override fun onInject() { component.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.menu.apply {
            findItem(R.id.modeGrid).apply {
                setIcon(if(dataMode == DataModeEnum.GRID) {
                    R.drawable.ic_grid_mode_checked
                }
                else
                    R.drawable.ic_grid_mode)
            }
            findItem(R.id.modeList).apply {
                setIcon(if(dataMode == DataModeEnum.LIST) {
                    dataMode = DataModeEnum.LIST
                    R.drawable.ic_list_mode_checked
                } else
                    R.drawable.ic_list_mode)
            }
        }

        toolbar.setOnMenuItemClickListener {

            toolbar.menu.apply {
                findItem(R.id.modeGrid).setIcon(R.drawable.ic_grid_mode)
                findItem(R.id.modeList).setIcon(R.drawable.ic_list_mode)
            }

            when(it.itemId) {
                R.id.modeGrid -> {
                    it.setIcon(R.drawable.ic_grid_mode_checked)
                    dataMode = DataModeEnum.GRID
                    requestUpdateDataList()
                }
                R.id.modeList -> {
                    it.setIcon(R.drawable.ic_list_mode_checked)
                    dataMode = DataModeEnum.LIST
                    requestUpdateDataList()
                }
                else -> { }
            }
            true
        }


    }

    /**
     * On Create Layout Manager
     */
    override fun onCreateLayoutManager(): RecyclerView.LayoutManager =
        if(dataMode == DataModeEnum.GRID)
            StaggeredGridLayoutManager(GRID_LAYOUT_SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
        else
            super.onCreateLayoutManager()

    /**
     * On Create Adapter
     */
    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Publication> =
        if(dataMode == DataModeEnum.GRID)
            CommonSimplePublicationAdapter(
                requireContext(),
                ArrayList()
            )
        else
            CommonPublicationAdapter(
                requireContext(),
                ArrayList()
            )

    /**
     * On Item Click
     */
    override fun onItemClick(item: Publication) {
        navigate(
            R.id.action_userProfileFragment_to_detailFragment
        )
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}


    enum class DataModeEnum {
        GRID, LIST
    }

    companion object {
        const val GRID_LAYOUT_SPAN_COUNT = 3
    }
}