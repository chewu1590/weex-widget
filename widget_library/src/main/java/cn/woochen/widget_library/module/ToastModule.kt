package cn.woochen.widget_library.module

import android.text.TextUtils
import android.widget.Toast
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.common.WXModule


/**
 *toast提示
 *@author woochen
 *@time 2019/9/17 14:26
 */
class ToastModule : WXModule() {
    @JSMethod(uiThread = true)
    fun showToast(msg: String?) {
        if (TextUtils.isEmpty(msg)) return
        Toast.makeText(mWXSDKInstance.context.applicationContext,msg,Toast.LENGTH_SHORT).show()
    }
}