package sanchez.sanchez.sergio.agrociety.ui.features.main.settings

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_change_photo_menu_bottom_sheet.*
import sanchez.sanchez.sergio.agrociety.R
import sanchez.sanchez.sergio.agrociety.di.components.fragment.UserSettingsComponent
import sanchez.sanchez.sergio.agrociety.di.factory.DaggerComponentFactory
import sanchez.sanchez.sergio.brownie.ui.core.activity.SupportActivity
import sanchez.sanchez.sergio.brownie.utils.SupportImagePicker
import javax.inject.Inject

class ChangePhotoMenuBottomSheet: BottomSheetDialogFragment() {

    private val component: UserSettingsComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerComponentFactory.getUserSettingsComponent(activity as SupportActivity)
    }

    @Inject
    lateinit var supportImagePicker: SupportImagePicker

    var listener: IOnChangePhotoMenuListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_change_photo_menu_bottom_sheet ,
            container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        changePhotoFromGallery.setOnClickListener {
            onChangePhotoFromGallery()
        }

        changePhotoFromCamera.setOnClickListener {
            onChangePhotoFromCamera()
        }

        resetPhoto.setOnClickListener {
            onResetPhoto()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (SupportImagePicker.DEFAULT_REQUEST_CODE == requestCode) {
            if(resultCode == RESULT_OK) {
                val imagePathFromResult = supportImagePicker
                    .getImagePathFromResult(requestCode, resultCode, data)
                if (imagePathFromResult != null) {
                    listener?.onImageSelected(imagePathFromResult)
                    dismissAllowingStateLoss()
                }
            }
        }
    }

    /**
     * Private Methods
     */

    /**
     * on change photo from gallery
     */
    private fun onChangePhotoFromGallery(){
        supportImagePicker.pickImage(requireActivity(), "Choose Photo From", true)
    }

    /**
     * on change photo from camera
     */
    private fun onChangePhotoFromCamera() {
        supportImagePicker.pickImage(requireActivity(), "Choose Photo From", false)
    }

    /**
     * on reset photo
     */
    private fun onResetPhoto() {}


    /**
     * On Change Photo Menu Listener
     */
    interface IOnChangePhotoMenuListener {

        /**
         * On Image Selected
         * @param imageSelected
         */
        fun onImageSelected(imageSelected: String)

        /**
         * on Reset Photo
         */
        fun onResetPhoto()

    }


    companion object {
        const val TAG = "ModalBottomSheet"
    }
}