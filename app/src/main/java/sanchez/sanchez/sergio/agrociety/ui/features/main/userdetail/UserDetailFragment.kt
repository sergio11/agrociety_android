package sanchez.sanchez.sergio.agrociety.ui.features.main.userdetail

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.lifecycle.Observer
import com.google.android.material.appbar.AppBarLayout
import com.squareup.picasso.Picasso
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_user_detail_fragment.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserDetailComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.User
import sanchez.sanchez.sergio.brownie.extension.popBackStack
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import javax.inject.Inject
import kotlin.math.abs

class UserDetailFragment: SupportFragment<UserDetailViewModel, Void>(UserDetailViewModel::class.java),
    AppBarLayout.OnOffsetChangedListener{

    private val component: UserDetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getUserDetailComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    private var mIsTheTitleVisible = false

    override fun onStart() {
        super.onStart()
        placeholderImageView.resume()
    }

    override fun onStop() {
        super.onStop()
        placeholderImageView.pause()
    }

    override fun layoutId(): Int =
        R.layout.fragment_user_detail_fragment

    override fun onInject() {
        component.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.follow.observe(this, Observer {
            onToggleFollow(it)
        })

        viewModel.userDetail.observe(this, Observer {
            onUserLoaded(it)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = UserDetailFragmentArgs.fromBundle(requireArguments())

        onUserLoaded(args.user)

        toolbar.setNavigationOnClickListener {
            popBackStack()
        }

        followUserBtn.setOnClickListener {
            viewModel.toogleFollow()
        }

        titleFrameLayout.setupWith(parallaxContainer)
            .setFrameClearDrawable(parallaxContainer.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(4.0f)
            .setHasFixedTransformationMatrix(true)

        appBarLayout.addOnOffsetChangedListener(this)
        startAlphaAnimation(titleTextView, 0, View.INVISIBLE)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, offset: Int) {
        appBarLayout?.let {
            val maxScroll = it.totalScrollRange
            val percentage = abs(offset).toFloat() / maxScroll.toFloat()
            handleToolbarTitleVisibility(percentage)
        }
    }

    /**
     * Private Methods
     */

    private fun handleToolbarTitleVisibility(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(titleTextView, ALPHA_ANIMATIONS_DURATION, View.VISIBLE)
                mIsTheTitleVisible = true
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(titleTextView, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE)
                mIsTheTitleVisible = false
            }
        }
    }

    private fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
        val alphaAnimation = if (visibility == View.VISIBLE)
            AlphaAnimation(0f, 1f)
        else
            AlphaAnimation(1f, 0f)

        alphaAnimation.duration = duration
        alphaAnimation.fillAfter = true
        v.startAnimation(alphaAnimation)
    }

    /**
     * On User Loaded
     * @param user
     */
    private fun onUserLoaded(user: User) {
        userName.text = user.displayName
        picasso.load(user.photoUrl).into(userImageView)
        placeholderImageView.setImageResource(user.background)
        followCountLabel.text = user.follow.toString()
        followersCountLabel.text = user.followers.toString()
    }

    /**
     * On Toggle Follow
     * @param status
     */
    private fun onToggleFollow(status: Boolean) {
        followUserBtn.text = if(status)
            getString(R.string.user_detail_unfollow_btn)
        else
            getString(R.string.user_detail_follow_btn)
    }

    companion object {

        const val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f
        const val ALPHA_ANIMATIONS_DURATION = 200L
    }
}