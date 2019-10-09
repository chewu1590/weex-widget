package cn.woochen.widget_library.adapter.extend

import android.content.Intent
import com.taobao.weex.bridge.JSCallback

interface IScanAdapter {
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    fun openScan(jsCallback: JSCallback?)
}