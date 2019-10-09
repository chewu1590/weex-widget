package cn.woochen.widget_library.module

import cn.woochen.widget_library.config.WeexConfigManager
import com.taobao.weex.annotation.JSMethod
import com.taobao.weex.bridge.JSCallback
import com.taobao.weex.common.WXModule

/**
 *获取原生常量值
 *@author woochen
 *@time 2019/10/9 17:06
 */
class TokenModule: WXModule() {

    @JSMethod
    fun getToken(jsCallback: JSCallback?) {
        WeexConfigManager.tokenAdapter?.setParams(jsCallback)
    }


}