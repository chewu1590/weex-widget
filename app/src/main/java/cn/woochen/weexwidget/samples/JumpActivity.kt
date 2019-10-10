package cn.woochen.weexwidget.samples

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import cn.woochen.weexwidget.R
import cn.woochen.weexwidget.utils.FileUtil
import cn.woochen.weexwidget.utils.logWeex
import com.alibaba.fastjson.JSON
import com.taobao.weex.IWXRenderListener
import com.taobao.weex.WXSDKEngine
import com.taobao.weex.WXSDKInstance
import com.taobao.weex.appfram.navigator.IActivityNavBarSetter
import com.taobao.weex.common.Constants
import com.taobao.weex.common.WXRenderStrategy
import kotlinx.android.synthetic.main.activity_jump.*


/**
 *Weex过渡activity
 *@author woochen
 *@time 2019/9/20 15:59
 */
class JumpActivity : AppCompatActivity(), IWXRenderListener {

    private var DEFAULT_BUNDER_URL = "http://192.168.1.34:8081/dist/index.js"
    private val DEFAULT_TITLE = "测试标题"
    private val INSTANCE_ID = "instanceId"
    private val WEEX = "cn.woochen.widget_library.android.intent.category.WEEX"

    private var mBundUrl = ""
    private var mWeexParams: HashMap<String, Any>? = null
    private var mWXSDKInstance: WXSDKInstance? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(R.layout.activity_jump)
        initData()

    }



     fun initData() {
        val url = intent.data
        val title = intent.getStringExtra("title")
        val weexPrams = intent.getStringExtra("weexPrams")

        if (url != null && !TextUtils.isEmpty(url.toString())) {
            mBundUrl = url.toString()
        } else {
            mBundUrl = DEFAULT_BUNDER_URL
        }
        if (!TextUtils.isEmpty(title)) {
            base_title_view.setTitle(title)
        } else {
            base_title_view.setTitle(DEFAULT_TITLE)
        }
        if (!TextUtils.isEmpty(weexPrams)) {
            mWeexParams = HashMap()
            mWeexParams?.put("params", weexPrams)
        }
        initListener()
        setNavigators()
        mWXSDKInstance?.destroy()
        initWxSdk()
    }

    private fun initListener() {
        tv_reload.setOnClickListener {
            mWXSDKInstance?.destroy()
            initWxSdk()
        }
    }

    /**
     * 设置导航栏
     */
    private fun setNavigators() {
        WXSDKEngine.setActivityNavBarSetter(object : IActivityNavBarSetter {
            override fun clearNavBarLeftItem(param: String?): Boolean {
                return true
            }

            override fun clearNavBarMoreItem(param: String?): Boolean {
                return true
            }

            override fun setNavBarLeftItem(param: String?): Boolean {
                return true
            }

            override fun setNavBarRightItem(param: String?): Boolean {
                return true
            }

            override fun clearNavBarRightItem(param: String?): Boolean {
                return true
            }

            override fun pop(param: String?): Boolean {
                return false
            }

            override fun setNavBarTitle(param: String?): Boolean {
                return true
            }

            override fun setNavBarMoreItem(param: String?): Boolean {
                return true
            }

            override fun push(param: String?): Boolean {
                if (!TextUtils.isEmpty(param)) {
                    try {
                        val jsonObject = JSON.parseObject(param)
                        val url = jsonObject.getString("url")
                        val title = jsonObject.getString("title")
                        val name = jsonObject.getString("name")
                        val debug = jsonObject.getBoolean("debug")?:false
                        val weexPrams = jsonObject.getString("params")
                        if (!TextUtils.isEmpty(url)) {
                            val rawUri = Uri.parse(url)
                            val scheme = rawUri.scheme
                            val builder = rawUri.buildUpon()
                            if (TextUtils.isEmpty(scheme)) {
                                builder.scheme(Constants.Scheme.HTTP)
                            }
                            val intent = Intent(Intent.ACTION_VIEW, builder.build())
                            intent.addCategory(WEEX)
                            intent.putExtra("title", title)
                            intent.putExtra("name", name)
                            intent.putExtra("debug", debug)
                            intent.putExtra("weexPrams", weexPrams)
                            intent.putExtra(INSTANCE_ID, mWXSDKInstance!!.instanceId)
                            startActivity(intent)
                        }
                    } catch (e: Exception) {
                        logWeex("message=${e.message!!}")
                    }
                }
                return true
            }


        })
    }

    /**
     * 初始化weex sdk
     */
    private fun initWxSdk() {
        mWXSDKInstance = WXSDKInstance(this)
        //注册global事件


        mWXSDKInstance?.registerRenderListener(this)
        val pageName = intent.getStringExtra("name")
        logWeex("加载url文件名称：$pageName url地址:$mBundUrl")
        mWXSDKInstance?.renderByUrl(pageName, mBundUrl, mWeexParams, null, WXRenderStrategy.APPEND_ASYNC)
//        mWXSDKInstance?.render(pageName, FileUtil.readAssetsTxt(this,"index.js"), null, null, WXRenderStrategy.APPEND_ASYNC);
    }



    override fun onRefreshSuccess(instance: WXSDKInstance?, width: Int, height: Int) {

    }

    override fun onException(instance: WXSDKInstance?, errCode: String?, msg: String?) {
        fl_error.visibility = View.VISIBLE
    }

    override fun onViewCreated(instance: WXSDKInstance?, view: View?) {
        fl_container.addView(view)
    }

    override fun onRenderSuccess(instance: WXSDKInstance?, width: Int, height: Int) {
        fl_error.visibility = View.GONE
    }


    override fun onResume() {
        super.onResume()
        mWXSDKInstance?.onActivityResume()

    }

    override fun onPause() {
        super.onPause()
        mWXSDKInstance?.onActivityPause()

    }

    override fun onStop() {
        super.onStop()
        mWXSDKInstance?.onActivityStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mWXSDKInstance?.onActivityDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        mWXSDKInstance?.onActivityResult(requestCode, resultCode, data)

    }



}
