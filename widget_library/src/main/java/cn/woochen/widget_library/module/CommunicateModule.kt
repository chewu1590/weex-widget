package cn.woochen.widget_library.module

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.TextUtils
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.common.WXModule
/**
 *交流module
 *@author woochen
 *@time 2019/10/9 10:54
 */
class CommunicateModule: WXModule() {
    private var mContext: Context? = null

    /**
     * 拨号
     */
    @JSMethod
    fun dial(phoneNumber: String?) {
        mContext = mWXSDKInstance.context
        if (TextUtils.isEmpty(phoneNumber)) return
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("tel:$phoneNumber")
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        mContext?.startActivity(intent)
    }
}