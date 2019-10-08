package cn.woochen.widget_library.adapter

import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.taobao.weex.WXSDKManager
import com.taobao.weex.adapter.IWXImgLoaderAdapter
import com.taobao.weex.common.WXImageStrategy
import com.taobao.weex.dom.WXImageQuality

/**
 *图片适配器
 *@author woochen
 *@time 2019/9/10 15:58
 */
class ImageAdapter : IWXImgLoaderAdapter {

    override fun setImage(url: String?, view: ImageView?, quality: WXImageQuality?, strategy: WXImageStrategy?) {
        if (TextUtils.isEmpty(url)) return
        WXSDKManager.getInstance().postOnUiThread({
            if (view?.context != null){
                Glide.with(view.context!!).load(url).into(view)
            }
        }, 0)
    }
}