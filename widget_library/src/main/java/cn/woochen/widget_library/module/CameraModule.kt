package cn.woochen.widget_library.module

import android.content.Intent
import android.util.Log
import cn.woochen.widget_library.config.WeexConfigManager
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.bridge.JSCallback
import com.taobao.weex.common.WXModule

/**
 *照片选择组件
 *@author woochen
 *@time 2019/9/17 14:42
 */
class CameraModule : WXModule() {

    private val mCameraAdapter by lazy {
        WeexConfigManager.cameraAdapter
    }

    private val mContext by lazy {
        mWXSDKInstance.context!!
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>?, grantResults: IntArray?) {
        mCameraAdapter?.onRequestPermissionsResult(requestCode,permissions,grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mCameraAdapter?.onActivityResult(requestCode,resultCode,data)
    }

    @JSMethod(uiThread = true)
    fun takePhoto(optionsObj: JSONObject?, jSCallback: JSCallback?) {
        mCameraAdapter?.takePhoto(optionsObj,jSCallback,mContext)
    }
}