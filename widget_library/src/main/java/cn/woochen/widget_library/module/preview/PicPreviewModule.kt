package cn.woochen.widget_library.module.preview

import android.app.Activity
import android.content.Context
import android.text.TextUtils
import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.JSONObject
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.common.WXModule

class PicPreviewModule: WXModule() {
    private var mContext: Context? = null

    @JSMethod
    fun picPreview( params: JSONObject?) {
        mContext = mWXSDKInstance.context

        val startPosition = params?.getIntValue("index") ?: 0
        val images = params?.getString("images") ?: ""
        var imageList = arrayListOf<String>()
        if(!TextUtils.isEmpty(images)) {
            imageList = JSON.parseArray(images, String::class.java) as ArrayList<String>
        }
        PreviewDialogFragment.newInstance(startPosition, imageList).show(mContext as Activity)
    }
}