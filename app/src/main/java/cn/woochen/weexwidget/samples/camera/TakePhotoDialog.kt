package cn.woochen.weexwidget.samples.camera


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cn.woochen.common_sdk.takephoto.core.TakePhoto
import cn.woochen.common_sdk.takephoto.helper.TakePhotoHelper
import cn.woochen.weexwidget.R

/**
 *拍照dialog
 *@author woochen
 *@time 2019/4/11 16:07
 */
class TakePhotoDialog : DialogFragment(), View.OnClickListener {

    private var mTakePhoto: TakePhoto? = null
    private var mLimitCount: Int = 1
    private var takePhotoHelper: TakePhotoHelper? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.dialog_fragment)
    }

    fun setTakePhoto(takePhoto: TakePhoto, isCrop: Boolean,limitCount:Int?) {
        this.mTakePhoto = takePhoto
        this.mLimitCount = limitCount ?: 0
        takePhotoHelper = TakePhotoHelper(mTakePhoto!!)
        takePhotoHelper!!.setCorpOption(isCrop)
                .setCompressOption(true, true, false)
                .setPicOption(false, false)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.dialog_take_photo, container, false)
        initView(rootView)
        return rootView
    }


    private fun initView(rootView: View) {
        // 设置宽度为屏宽、靠近屏幕底部。
        val window = dialog.window
        val wlp = window!!.attributes
        wlp.gravity = Gravity.BOTTOM
        window.attributes = wlp
        val tv_cancel = rootView.findViewById<TextView>(R.id.tv_cancel)
        val tv_take_photo = rootView.findViewById<TextView>(R.id.tv_take_photo)
        val tv_album = rootView.findViewById<TextView>(R.id.tv_album)
        tv_cancel.setOnClickListener(this)
        tv_take_photo.setOnClickListener(this)
        tv_album.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_cancel -> dismiss()
            R.id.tv_take_photo -> {
                if (takePhotoHelper != null) {
                    takePhotoHelper!!.takePhoto()
                }
                dismiss()
            }
            R.id.tv_album -> {
                if (takePhotoHelper != null) {
                    takePhotoHelper!!.pickFormGallery(mLimitCount)
                }
                dismiss()
            }
        }
    }

    /**
     * 显示弹窗
     */
    fun show(context: Context) {
        val tag = "camera_dialog"
        var manager: FragmentManager? = null
        if (context is Fragment) {
            manager = context.fragmentManager
        }
        if (context is AppCompatActivity) {
            manager = context.supportFragmentManager
        }
        show(manager, tag)
    }


    companion object {

        fun newInsatance(): TakePhotoDialog {
            return TakePhotoDialog()
        }
    }
}
