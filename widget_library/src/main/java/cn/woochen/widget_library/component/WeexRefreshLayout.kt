package cn.woochen.widget_library.component

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.scwang.smart.refresh.layout.SmartRefreshLayout
import com.scwang.smart.refresh.layout.wrapper.RefreshContentWrapper


/**
 *重置内容显示视图(继承SmartRefreshLayout)
 *@author woochen
 *@time 2019/10/10 14:17
 */
class WeexRefreshLayout : SmartRefreshLayout{

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs)

    fun setContentView(view: View) {
        mRefreshContent = RefreshContentWrapper(view)
        bringChildToFront(view)
    }
}
