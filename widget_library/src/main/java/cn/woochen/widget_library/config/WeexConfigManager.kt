package cn.woochen.widget_library.config

import cn.woochen.widget_library.adapter.extend.ICameraAdapter
import cn.woochen.widget_library.adapter.extend.INativeViewAdapter
import cn.woochen.widget_library.adapter.extend.IScanAdapter
import cn.woochen.widget_library.adapter.extend.ITokenAdapter

/**
 *weex配置相关管理类
 *@author woochen
 *@time 2019/10/9 13:54
 */
object WeexConfigManager {

    var cameraAdapter: ICameraAdapter? = null
    var tokenAdapter: ITokenAdapter? = null
    var nativeViewAdapter: INativeViewAdapter? = null
    var scanAdapter: IScanAdapter? = null

    fun setConfigAdapters(weexConfig: WeexConfig) {
        cameraAdapter = weexConfig.getCameraAdapter()
        tokenAdapter = weexConfig.getTokenAdapter()
        nativeViewAdapter = weexConfig.getNativeViewAdapter()
        scanAdapter = weexConfig.getScanAdapter()
    }
}