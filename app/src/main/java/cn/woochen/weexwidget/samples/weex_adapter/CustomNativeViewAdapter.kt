package cn.woochen.weexwidget.samples.weex_adapter

import android.content.Context
import android.content.Intent
import cn.woochen.weexwidget.MainActivity
import cn.woochen.widget_library.adapter.extend.INativeViewAdapter
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.bridge.JSCallback

class CustomNativeViewAdapter:INativeViewAdapter {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    override fun gotoNativeView(context: Context?, pageName: String, params: JSONObject?, jsCallback: JSCallback?) {
        when (pageName) {
            "main" -> {
                val intent = Intent(context, MainActivity::class.java)
                context?.startActivity(intent)
            }
            else -> {
            }
        }
    }
}