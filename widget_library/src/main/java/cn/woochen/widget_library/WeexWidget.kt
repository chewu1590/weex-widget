package cn.woochen.widget_library

import android.app.Application
import cn.woochen.widget_library.adapter.ImageAdapter
import com.alibaba.android.bindingx.plugin.weex.BindingX
import com.taobao.weex.InitConfig
import com.taobao.weex.WXSDKEngine

/**
 *weex配置类
 *@author woochen
 *@time 2019/10/8 15:51
 */
object WeexWidget {

    fun init(application: Application){
        initWeexSdk(application)
        registerExtend()
    }


    /**
     * 初始化weex sdk
     */
    private fun initWeexSdk(application: Application) {
        //register sdk
        val config = InitConfig.Builder()
            .setImgAdapter(ImageAdapter())
            .build()
        WXSDKEngine.initialize(application, config)
        //register bindingx
        BindingX.register()
    }

    /**
     * native扩展注册
     */
    private fun registerExtend() {
        //module
//        WXSDKEngine.registerModule("ToastModule", ToastModule::class.java)
//        WXSDKEngine.registerModule("CameraModule", CameraModule::class.java)
//        WXSDKEngine.registerModule("TokenModule", TokenModule::class.java)
//        WXSDKEngine.registerModule("NativeViewModule", NativeViewModule::class.java)
//        WXSDKEngine.registerModule("DatePickerModule", DatePickerModule::class.java)
//        WXSDKEngine.registerModule("LocationModule", LocationModule::class.java)
//        WXSDKEngine.registerModule("ScanModule", ScanModule::class.java)
//        WXSDKEngine.registerModule("CommunicateModule", CommunicateModule::class.java)
//        WXSDKEngine.registerModule("PicPreviewModule", PicPreviewModule::class.java)
//        WXSDKEngine.registerModule("LoadingModule", LoadingModule::class.java)
        //component
//        WXSDKEngine.registerComponent("smartRefreshView", SmartRefreshView::class.java)
    }

}