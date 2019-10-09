package cn.woochen.weexwidget.samples.weex_adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import cn.woochen.common_sdk.takephoto.core.TakePhoto
import cn.woochen.common_sdk.takephoto.core.TakePhotoImpl
import cn.woochen.common_sdk.takephoto.model.InvokeParam
import cn.woochen.common_sdk.takephoto.model.TContextWrap
import cn.woochen.common_sdk.takephoto.model.TResult
import cn.woochen.common_sdk.takephoto.permission.InvokeListener
import cn.woochen.common_sdk.takephoto.permission.PermissionManager
import cn.woochen.common_sdk.takephoto.permission.TakePhotoInvocationHandler
import cn.woochen.weexwidget.samples.camera.TakePhotoDialog
import cn.woochen.weexwidget.utils.logWeex
import cn.woochen.widget_library.adapter.extend.ICameraAdapter
import cn.woochen.widget_library.bean.WeexResponseBean
import cn.woochen.widget_library.constants.ResonseCode
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.bridge.JSCallback

class CustomCameraAdapter : ICameraAdapter, TakePhoto.TakeResultListener,
    InvokeListener {
    private var mContext: Context? = null
    private var invokeParam: InvokeParam? = null
    private var takePhoto: TakePhoto? = null
    private var mPicChooseCallBack: JSCallback? = null
    private var mFlag: String? = ""

    override fun takeSuccess(result: TResult?) {
        logWeex("takeSuccess:")
        val images = result?.images
        val desPaths = mutableListOf<String>()
        images?.forEach {
            desPaths.add(it.originalPath)
        }
        mPicChooseCallBack?.invoke(WeexResponseBean(ResonseCode.RESULT_OK, "success", desPaths))
    }

    override fun takeCancel() {
        logWeex("takeCancel:")
    }

    override fun takeFail(result: TResult?, msg: String?) {
        logWeex("takeFail:$msg")
    }

    override fun invoke(invokeParam: InvokeParam?): PermissionManager.TPermissionType {
        if (mContext is Activity) {
            val type = PermissionManager.checkPermission(TContextWrap.of(mContext as Activity), invokeParam?.method!!)
            if (PermissionManager.TPermissionType.WAIT == type) {
                this.invokeParam = invokeParam
            }
            return type
        }
        return PermissionManager.TPermissionType.NOT_NEED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>?,
        grantResults: IntArray?
    ) {
        val type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (mContext is Activity) {
            PermissionManager.handlePermissionsResult(mContext as Activity, type, invokeParam, this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        getTakePhoto()?.onActivityResult(requestCode, resultCode, data)
    }

    /**
     * 获取TakePhoto实例
     */
    private fun getTakePhoto(): TakePhoto? {
        if (takePhoto == null && mContext is Activity) {
            takePhoto = TakePhotoInvocationHandler.of(this).bind(TakePhotoImpl(mContext as Activity, this)) as TakePhoto
            return takePhoto
        }
        return takePhoto
    }

    override fun takePhoto(
        optionsObj: JSONObject?,
        jSCallback: JSCallback?,
        context: Context
    ) {
        this.mContext = context
        if (jSCallback != null) {
            mPicChooseCallBack = jSCallback
        }
        var flag: String? = optionsObj?.getString("flag")
        val limit = optionsObj?.getString("limit")
        mFlag = flag
        logWeex("flag:$flag limit:$limit")
        val takePhotoDialog = TakePhotoDialog.newInsatance()
        try {
            if (getTakePhoto() != null) {
                takePhotoDialog.setTakePhoto(getTakePhoto()!!, false, limit?.toInt())
                takePhotoDialog.show(mContext!!)
            } else {
                Toast.makeText(mContext, "相机初始化失败！", Toast.LENGTH_SHORT).show()
            }
        } catch (e: Exception) {
            logWeex("异常：${e.message}")
            Toast.makeText(mContext, "请设置合法的参数！", Toast.LENGTH_SHORT).show()
        }
    }
}