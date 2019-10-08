package cn.woochen.weexwidget.utils

import android.content.Context
import android.widget.Toast
import cn.woochen.weexwidget.BuildConfig

/**
 * weex日志
 */
fun Any.logWeex(msg: String) {
    if (BuildConfig.DEBUG) println("logWeex -----------> $msg")
}

/**
 * 常规日志打印
 * 过滤关键字 logcom
 */
fun Any.logcom(msg: String){
    if (BuildConfig.DEBUG) println("logcom -----------> $msg")
}

/**
 * UI日志打印
 * 过滤关键字 logui
 */
fun Any.logui(msg: String){
    if (BuildConfig.DEBUG) println("logui -----------> $msg")
}

/**
 * 流程日志打印
 * 过滤关键字 logprocess
 */
fun Any.logprocess(msg: String){
    if (BuildConfig.DEBUG) println("logprocess -----------> $msg")
}



/**
 * toast信息
 */
fun Any.toast(context: Context,msg: String) {
    Toast.makeText(context.applicationContext, msg, Toast.LENGTH_SHORT).show()
}