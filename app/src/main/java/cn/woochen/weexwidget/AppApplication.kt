package cn.woochen.weexwidget

import android.app.Application
import cn.woochen.widget_library.WeexWidget

class AppApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        WeexWidget.init(this)
    }
}