package cn.woochen.widget_library.adapter

import android.annotation.SuppressLint
import android.text.TextUtils
import android.util.Log
import android.widget.ImageView
import cn.woochen.widget_library.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
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

    private val BUDLER_ADDRESS = "http://192.168.1.34:8081"

    @SuppressLint("CheckResult")
    override fun setImage(url: String?, view: ImageView?, quality: WXImageQuality?, strategy: WXImageStrategy?) {
        Log.e("ImageAdapter","图片地址：$url")
        if (TextUtils.isEmpty(url)) return
        WXSDKManager.getInstance().postOnUiThread({
            if (view?.context != null){
                if (url?.contains(BUDLER_ADDRESS)!!){
                   Glide.with(view.context!!).load(url.replace(BUDLER_ADDRESS,"")).into(view)
               }else{
                   Glide.with(view.context!!).load(url).into(view)
               }
               /* val requestOptions = RequestOptions()
                requestOptions.placeholder(R.drawable.ic_default_pic).error(R.drawable.ic_default_pic)
                Glide.with(view.context!!).load(url).apply(requestOptions).into(view)*/
            }
        }, 0)
    }
}