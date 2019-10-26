package sanchez.sanchez.sergio.agrociety.ui.features.intro

import android.os.Bundle
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.activity_intro.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.agrociety.di.components.activity.IntroActivityComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory

class IntroActivity : SupportActivity() {

    private val activityComponent: IntroActivityComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getIntroActivityComponent(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_NoActionBar)
        super.onCreate(savedInstanceState)

        containerBlurView.setupWith(container)
            .setFrameClearDrawable(container.background)
            .setBlurAlgorithm(RenderScriptBlur(baseContext))
            .setBlurRadius(4.0f)
            .setHasFixedTransformationMatrix(true)
    }

    override fun onStart() {
        super.onStart()
        screenBackground.resume()
    }

    override fun onStop() {
        super.onStop()
        screenBackground.pause()
    }

    override fun layoutId(): Int = R.layout.activity_intro

    override fun navHostId(): Int = R.id.navHostContainer

    override fun onInject() { activityComponent.inject(this) }
}
