package sanchez.sanchez.sergio.agrociety.ui.features.main.postdetail

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.lifecycle.Observer
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import eightbitlab.com.blurview.RenderScriptBlur
import kotlinx.android.synthetic.main.fragment_post_detail.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.DetailComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Post
import sanchez.sanchez.sergio.brownie.extension.*
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportFragment
import javax.inject.Inject
import kotlin.math.abs

class PostDetailFragment: SupportFragment<PostDetailViewModel, Void>(PostDetailViewModel::class.java),
    AppBarLayout.OnOffsetChangedListener{


    private val component: DetailComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getDetailComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    private var mIsTheTitleVisible = false

    override fun layoutId(): Int = R.layout.fragment_post_detail

    override fun onInject() { component.inject(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.like.observe(this, Observer { hasLike ->
            likeButton.apply {
                isEnabled = true
                changeImageViewTintWithColorRes(if(hasLike)
                    R.color.redDanger
                else
                    R.color.textColorSecondary)
            }

            showSnackbar(if(hasLike)
                getString(R.string.post_detail_like_this_post)
            else
                getString(R.string.post_detail_no_like_this_post), Snackbar.LENGTH_LONG)

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val post = PostDetailFragmentArgs
            .fromBundle(requireArguments())
            .post

        onPostLoaded(post)

        toolbar.apply {
            setNavigationOnClickListener {
                popBackStack()
            }
            setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.sharePublication -> {
                       requireActivity().shareSimpleContent(
                           textTitle = "${post.title} - ${post.subtitle}",
                           textContent = "Contenido de la aplicación, ver más en Agrociety"
                       )
                    }
                    else -> {}
                }
                true
            }
        }


        containerBlurView.setupWith(diagonalLayout)
            .setFrameClearDrawable(diagonalLayout.background)
            .setBlurAlgorithm(RenderScriptBlur(requireContext()))
            .setBlurRadius(1.0f)
            .setHasFixedTransformationMatrix(true)

        appBarLayout.addOnOffsetChangedListener(this)
        startAlphaAnimation(titleTextView, 0, View.INVISIBLE)

        likeButton.setOnClickListener {
            likeButton.isEnabled = false
            viewModel.toggleLike()
        }

    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        appBarLayout?.let {
            val maxScroll = it.totalScrollRange
            val percentage = abs(verticalOffset).toFloat() / maxScroll.toFloat()
            handleToolbarTitleVisibility(percentage)
        }
    }

    /**
     * Private methods
     */

    private fun onPostLoaded(post: Post) {
        parallaxImage.setImageResource(post.image)
        postTitle.text = post.title
        postSubtitle.text = post.subtitle
        postDate.text = post.date.toStringFormat(getString(R.string.date_format))

        post.author.photoUrl?.let { photo ->
            picasso.load(photo)
                .error(R.drawable.developer_image)
                .into(postAuthorPhoto)
        } ?: kotlin.run {
            postAuthorPhoto.setImageResource(R.drawable.developer_image)
        }

        postAuthorName.text = post.author.displayName
        titleTextView.text = post.title
        commentsCount.text = post.commentsCount.toString()
        likeCount.text = post.likesCount.toString()

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