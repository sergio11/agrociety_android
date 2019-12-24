package sanchez.sanchez.sergio.agrociety.ui.features.main.postdetail.comments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.scale
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.fragment_comments_wall_layout.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.CommentsWallComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.agrociety.domain.model.Comment
import sanchez.sanchez.sergio.agrociety.ui.features.main.home.HomeFragmentDirections
import sanchez.sanchez.sergio.brownie.extension.getCircularBitmap
import sanchez.sanchez.sergio.brownie.extension.navigate
import sanchez.sanchez.sergio.brownie.extension.showSnackbar
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.ui.core.adapter.SupportRecyclerViewAdapter
import sanchez.sanchez.sergio.brownie.ui.core.fragment.SupportLCEFragment
import javax.inject.Inject

class CommentsWallFragment: SupportLCEFragment<Void, Comment, Void, CommentsWallViewModel>(CommentsWallViewModel::class.java) {

    private val component: CommentsWallComponent by lazy {
        DaggerComponentFactory.getCommentsWallComponent(requireActivity() as SupportActivity)
    }

    @Inject
    lateinit var picasso: Picasso

    override fun layoutId(): Int = R.layout.fragment_comments_wall_layout

    override fun onInject() {
        component.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        picasso.load("https://media.licdn.com/dms/image/C5603AQH-UJpm-rC6Vw/profile-displayphoto-shrink_200_200/0?e=1579737600&v=beta&t=by5w9yrq3fkoRwPFBMyStEkFz4WANDHixto4KX2nbwA")
            .into(object : Target {
                override fun onPrepareLoad(placeHolderDrawable: Drawable?) {}
                override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {
                    toolbar.navigationIcon = ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.developer_image
                    )
                }

                override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {

                    bitmap?.let {
                        toolbar.navigationIcon = BitmapDrawable(
                            requireContext().resources,
                            it
                                .scale(width = it.width / 2, height = it.height / 2)
                                .getCircularBitmap()
                        )
                    } ?: kotlin.run {
                        toolbar.navigationIcon = ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.developer_image
                        )
                    }
                }
            })


        sendCommentBtn.setOnClickListener {
            commentEditText.text.toString().let {commentText ->
                showSnackbar("Comment $commentText", Snackbar.LENGTH_LONG)
                commentEditText.text = null
            }
        }
    }

    override fun onCreateAdapter(): SupportRecyclerViewAdapter<Comment> =
        CommentsWallAdapter(picasso, requireContext(), mutableListOf())

    override fun onItemClick(item: Comment) {
        navigate(HomeFragmentDirections.actionGlobalUserDetailFragment(item.author))
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {}
}