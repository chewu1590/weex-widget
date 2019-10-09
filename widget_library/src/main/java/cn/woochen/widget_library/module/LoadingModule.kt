package cn.woochen.widget_library.module

import cn.woochen.widget_library.R
import cn.woochen.widget_library.module.dialog.AlertDialog
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.common.WXModule

class LoadingModule: WXModule() {
    private var mLoadingDialog: AlertDialog? = null

    @JSMethod
    fun showLoading(params: JSONObject?) {
        val message = params?.getString("message") ?: ""

        val builder = AlertDialog.Builder(mWXSDKInstance.context)
        mLoadingDialog = builder.setContentView(R.layout.layout_text_loading)
            .setText(R.id.tv_desc, message)
            .create()
        mLoadingDialog?.setCanceledOnTouchOutside(false)
        mLoadingDialog?.show()
    }

    @JSMethod
    fun hideLoading() {
        mLoadingDialog?.dismiss()
    }
}