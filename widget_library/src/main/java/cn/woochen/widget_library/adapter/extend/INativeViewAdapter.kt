package cn.woochen.widget_library.adapter.extend

import android.content.Context
import android.content.Intent
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.bridge.JSCallback

interface INativeViewAdapter {
    fun gotoNativeView(context: Context?, pageName: String, params: JSONObject?, jsCallback: JSCallback?)
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}