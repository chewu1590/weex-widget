package cn.woochen.widget_library.module

import android.content.Intent
import cn.woochen.widget_library.config.WeexConfigManager
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.bridge.JSCallback
import com.taobao.weex.common.WXModule

/**
 *原生页面跳转
 *@author woochen
 *@time 2019/10/9 17:26
 */
class NativeViewModule : WXModule() {

    private val mNativeViewAdapter by lazy {
        WeexConfigManager.nativeViewAdapter
    }

    @JSMethod
    fun gotoNativeView(pageName: String, params: JSONObject?, jsCallback: JSCallback?) {
        mNativeViewAdapter?.gotoNativeView(mWXSDKInstance.context, pageName, params, jsCallback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mNativeViewAdapter?.onActivityResult(requestCode, resultCode, data)
    }

}