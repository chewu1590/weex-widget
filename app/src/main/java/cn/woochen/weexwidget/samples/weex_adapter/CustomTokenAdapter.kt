package cn.woochen.weexwidget.samples.weex_adapter

import cn.woochen.widget_library.adapter.extend.ITokenAdapter
import com.taobao.weex.bridge.JSCallback

class CustomTokenAdapter:ITokenAdapter {
    override fun setParams(jsCallback: JSCallback?) {
        val param = hashMapOf<String,Any>()
        param["token"] = "demo_token"
        param["apiUrl"] = "demo_url"
        jsCallback?.invoke(param)
    }
}