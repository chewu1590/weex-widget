package cn.woochen.weexwidget

import android.app.Application
import cn.woochen.weexwidget.samples.weex_adapter.CustomCameraAdapter
import cn.woochen.weexwidget.samples.weex_adapter.CustomNativeViewAdapter
import cn.woochen.weexwidget.samples.weex_adapter.CustomScanAdapter
import cn.woochen.weexwidget.samples.weex_adapter.CustomTokenAdapter
import cn.woochen.widget_library.config.WeexConfig
import cn.woochen.widget_library.WeexWidget

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val build = WeexConfig.Builder()
            .setCameraAdapter(CustomCameraAdapter())
            .setTokenAdapter(CustomTokenAdapter())
            .setNativeViewAdapter(CustomNativeViewAdapter())
            .setScanAdapter(CustomScanAdapter())
        WeexWidget.init(this, build.build(),null)
    }
}