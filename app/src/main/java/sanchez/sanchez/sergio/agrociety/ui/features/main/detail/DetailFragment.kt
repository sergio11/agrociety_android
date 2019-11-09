package sanchez.sanchez.sergio.agrociety.ui.features.main.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_detail.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.DetailComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment

class DetailFragment: SupportFragment<DetailViewModel, Void>(DetailViewModel::class.java) {

    private val component: DetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getDetailComponent(activity as SupportActivity)
    }

    override fun layoutId(): Int = R.layout.fragment_detail

    override fun onInject() { component.inject(this) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById(R.id.toolbar) as Toolbar

        containerBlurView.setupWith(diagonalLayout)
            .setFrameClearDrawable(diagonalLayout.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(1.0f)
            .setHasFixedTransformationMatrix(true)

    }
}