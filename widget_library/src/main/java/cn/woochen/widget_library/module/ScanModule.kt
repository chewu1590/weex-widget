package cn.woochen.widget_library.module

import android.annotation.SuppressLint
import android.content.Intent
import cn.woochen.widget_library.config.WeexConfigManager
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.bridge.JSCallback
import com.taobao.weex.common.WXModule

class ScanModule: WXModule() {

    private val mScanAdapter by lazy {
        WeexConfigManager.scanAdapter
    }

    @SuppressLint("CheckResult")
    @JSMethod
    fun openScan(jsCallback: JSCallback?) {
        mScanAdapter?.openScan(jsCallback)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        mScanAdapter?.onActivityResult(requestCode, resultCode, data)
    }
}