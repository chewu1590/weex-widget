package cn.woochen.widget_library.adapter.extend

import android.content.Context
import android.content.Intent
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.bridge.JSCallback

interface ICameraAdapter {
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>?, grantResults: IntArray?)
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    fun takePhoto(
        optionsObj: JSONObject?,
        jSCallback: JSCallback?,
        context: Context
    )
}