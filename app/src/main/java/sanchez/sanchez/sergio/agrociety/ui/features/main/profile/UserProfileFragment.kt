package sanchez.sanchez.sergio.agrociety.ui.features.main.profile

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import com.google.android.material.appbar.AppBarLayout
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_user_profile.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserProfileComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.ui.features.conversation.ConversationActivity
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import kotlin.math.abs

/**
 * User Profile Fragment
 */
class UserProfileFragment: SupportFragment<UserProfileViewModel, Void>(UserProfileViewModel::class.java),
    AppBarLayout.OnOffsetChangedListener {


    private val component: UserProfileComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getUserProfileComponent(activity as SupportActivity)
    }

    private var mIsTheTitleVisible = false

    override fun layoutId(): Int = R.layout.fragment_user_profile

    override fun onInject() { component.inject(this) }

    override fun onStart() {
        super.onStart()
        placeholderImageView.resume()
    }

    override fun onStop() {
        super.onStop()
        placeholderImageView.pause()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.goToConversations ->
                    navigate(ConversationActivity
                        .createDestination(requireActivity()))
                R.id.editUserProfile ->
                    navigate(R.id.action_userProfileFragment_to_userSettingsFragment)

            }
            true
        }

        titleFrameLayout.setupWith(parallaxContainer)
            .setFrameClearDrawable(parallaxContainer.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(4.0f)
            .setHasFixedTransformationMatrix(true)

        appBarLayout.addOnOffsetChangedListener(this)
        startAlphaAnimation(titleTextView, 0, View.INVISIBLE)


        followersCountButton.setOnClickListener {
            navigate(R.id.action_userProfileFragment_to_contactListFragment)
        }

        followCountButton.setOnClickListener {
            navigate(R.id.action_userProfileFragment_to_contactListFragment)
        }
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, offset: Int) {
        appBarLayout?.let {
            val maxScroll = it.totalScrollRange
            val percentage = abs(offset).toFloat() / maxScroll.toFloat()
            handleToolbarTitleVisibility(percentage)
        }
    }

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

    companion object {

        const val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f
        const val ALPHA_ANIMATIONS_DURATION = 200L
    }


}