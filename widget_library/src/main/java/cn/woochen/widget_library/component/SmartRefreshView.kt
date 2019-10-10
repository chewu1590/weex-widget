package cn.woochen.widget_library.component

import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader
import com.taobao.weex.WXSDKInstance
import com.taobao.weex.ui.action.BasicComponentData
import com.taobao.weex.ui.component.WXComponentProp
import com.taobao.weex.ui.component.WXVContainer

/**
 *刷新组件
 *@author woochen
 *@time 2019/10/10 17:32
 */
class SmartRefreshView(instance: WXSDKInstance, parent: WXVContainer<*>, basicComponentData: BasicComponentData<*>) :
    WXVContainer<WeexRefreshLayout>(instance, parent, basicComponentData) {

    private val weexRefreshLayout by lazy {
      WeexRefreshLayout(context)
    }

    override fun initComponentHostView(context: Context): WeexRefreshLayout {
        weexRefreshLayout.setOnRefreshListener {
            fireEvent("onRefreshing")//这里会调用js中组件上的方法
        }
        weexRefreshLayout.setOnLoadMoreListener {
            fireEvent("onLoadMoreing")
        }
        //配置样式
        val classicsHeader = ClassicsHeader(context)
        val classicsFooter = ClassicsFooter(context)
        weexRefreshLayout.setRefreshHeader(classicsHeader)
        weexRefreshLayout.setRefreshFooter(classicsFooter)
        weexRefreshLayout.setDisableContentWhenRefresh(true)
        weexRefreshLayout.setDisableContentWhenLoading(true)
        weexRefreshLayout.setEnableAutoLoadMore(false)

        return weexRefreshLayout
    }

    override fun addSubView(child: View?, index: Int) {
        super.addSubView(child, index)
        weexRefreshLayout.setContentView(child!!)
    }

    @WXComponentProp(name = "refresh")
    fun setDisplay(refreshStatus: String) {
       if (TextUtils.equals("hide", refreshStatus)) {
            hostView.finishRefresh()
            hostView.setNoMoreData(false)
        }
    }

    @WXComponentProp(name = "more")
    fun setMore(moreStatus: String) {
        when {
            TextUtils.equals("show", moreStatus) -> ""
            TextUtils.equals("hide", moreStatus) -> hostView.finishLoadMore()
            TextUtils.equals("nodata", moreStatus) -> hostView.finishLoadMoreWithNoMoreData()
        }
    }


    @WXComponentProp(name = "canLoadMore")
    fun setMore(canLoadMore: Boolean?) {
        hostView.setEnableLoadMore(canLoadMore!!)
    }

}
