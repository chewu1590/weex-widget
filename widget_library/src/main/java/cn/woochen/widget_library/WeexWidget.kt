package cn.woochen.widget_library

import android.app.Application
import cn.woochen.widget_library.adapter.ImageAdapter
import cn.woochen.widget_library.component.SmartRefreshView
import cn.woochen.widget_library.config.WeexConfig
import cn.woochen.widget_library.config.WeexConfigManager
import cn.woochen.widget_library.module.*
import cn.woochen.widget_library.module.preview.PicPreviewModule
import com.alibaba.android.bindingx.plugin.weex.BindingX
import com.taobao.weex.InitConfig
import com.taobao.weex.WXSDKEngine
import com.taobao.weex.common.WXModule
import java.lang.IllegalArgumentException

/**
 *weex实例类
 *@author woochen
 *@time 2019/10/8 15:51
 */
object WeexWidget {

    private var mIsInit: Boolean = false

    /**
     * @param application
     * @param weexConfig 自定义module适配器设置
     * @param initConfig weex sdk适配器设置
     */
    fun init(application: Application, weexConfig: WeexConfig, initConfig: InitConfig?) {
        initWeexSdk(application, initConfig)
        WeexConfigManager.setConfigAdapters(weexConfig)
        registerExtend()
    }


    /**
     * 初始化weex sdk
     */
    private fun initWeexSdk(application: Application, initConfig: InitConfig?) {
        //register sdk
        val config: InitConfig? = initConfig ?: InitConfig.Builder()
            .setImgAdapter(ImageAdapter())
            .build()
        WXSDKEngine.initialize(application, config)
        mIsInit = true
        //register bindingx
        BindingX.register()
    }

    /**
     * 注册module
     */
    fun registerModule(moduleName: String, moduleClass: Class<out WXModule>) {
        if (mIsInit) {
            WXSDKEngine.registerModule(moduleName, moduleClass)
        } else {
            throw IllegalArgumentException("please init WeexWidget first!")
        }
    }

    /**
     * native扩展注册
     */
    private fun registerExtend() {
        //module
        WXSDKEngine.registerModule("ToastModule", ToastModule::class.java)
        WXSDKEngine.registerModule("CameraModule", CameraModule::class.java)
        WXSDKEngine.registerModule("TokenModule", TokenModule::class.java)
        WXSDKEngine.registerModule("NativeViewModule", NativeViewModule::class.java)
//        WXSDKEngine.registerModule("DatePickerModule", DatePickerModule::class.java)
//        WXSDKEngine.registerModule("LocationModule", LocationModule::class.java)
        WXSDKEngine.registerModule("ScanModule", ScanModule::class.java)
        WXSDKEngine.registerModule("CommunicateModule", CommunicateModule::class.java)
        WXSDKEngine.registerModule("PicPreviewModule", PicPreviewModule::class.java)
        WXSDKEngine.registerModule("LoadingModule", LoadingModule::class.java)
        //component
        WXSDKEngine.registerComponent("SmartRefreshView", SmartRefreshView::class.java)
    }

}