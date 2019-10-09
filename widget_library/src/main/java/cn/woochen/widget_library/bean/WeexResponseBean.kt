package cn.woochen.widget_library.bean

data class WeexResponseBean<T> (var code:Int = 0, var msg:String = "", var data:T? = null)