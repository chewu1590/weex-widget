package cn.woochen.widget_library.config

import cn.woochen.widget_library.adapter.extend.ICameraAdapter
import cn.woochen.widget_library.adapter.extend.INativeViewAdapter
import cn.woochen.widget_library.adapter.extend.IScanAdapter
import cn.woochen.widget_library.adapter.extend.ITokenAdapter
import cn.woochen.widget_library.config.WeexConfigManager.nativeViewAdapter
import cn.woochen.widget_library.config.WeexConfigManager.tokenAdapter

class WeexConfig {
    private var mICameraAdapter: ICameraAdapter? = null
    private var mITokenAdapter: ITokenAdapter? = null
    private var mINativeViewAdapter: INativeViewAdapter? = null
    private var mIScanAdapter: IScanAdapter? = null

    fun getCameraAdapter(): ICameraAdapter? = mICameraAdapter

    fun getTokenAdapter(): ITokenAdapter? = mITokenAdapter

    fun getNativeViewAdapter(): INativeViewAdapter? = mINativeViewAdapter

    fun getScanAdapter(): IScanAdapter? = mIScanAdapter

     class Builder{
        private var mICameraAdapter: ICameraAdapter? = null
         private var mITokenAdapter: ITokenAdapter? = null
         private var mINativeViewAdapter: INativeViewAdapter? = null
         private var mIScanAdapter: IScanAdapter? = null

        fun setCameraAdapter(cameraAdapter: ICameraAdapter?): Builder {
            this.mICameraAdapter = cameraAdapter
            return this
        }

        fun setTokenAdapter(tokenAdapter: ITokenAdapter?): Builder {
            this.mITokenAdapter = tokenAdapter
            return this
        }

        fun setNativeViewAdapter(nativeViewAdapter: INativeViewAdapter?): Builder {
            this.mINativeViewAdapter = nativeViewAdapter
            return this
        }
        fun setScanAdapter(scanAdapter: IScanAdapter?): Builder {
            this.mIScanAdapter = scanAdapter
            return this
        }

        fun build(): WeexConfig {
            val weexConfig = WeexConfig()
            weexConfig.mICameraAdapter = mICameraAdapter
            weexConfig.mITokenAdapter = mITokenAdapter
            weexConfig.mINativeViewAdapter = mINativeViewAdapter
            weexConfig.mIScanAdapter = mIScanAdapter
            return weexConfig
        }
    }
}