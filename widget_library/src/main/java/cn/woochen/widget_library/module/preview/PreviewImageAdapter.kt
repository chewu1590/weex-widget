package cn.woochen.widget_library.module.preview

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import cn.woochen.widget_library.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


/**
 *预览适配器
 *@author woochen
 *@time 2019/4/12 13:48
 */
class PreviewImageAdapter: PagerAdapter {
    private var mContext: Context
    private var mDatas: MutableList<String>
    private var mlayoutInflater: LayoutInflater
    var onItemClickListener: OnItemClickListener? = null


    constructor(context: Context, datas: MutableList<String>) : super() {
        mContext = context
        mDatas = datas
        mlayoutInflater = LayoutInflater.from(mContext)
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = mDatas.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val viewRoot = mlayoutInflater.inflate(R.layout.item_preview, null)
        container.addView(viewRoot)
        val ivPreview = viewRoot.findViewById<ImageView>(R.id.iv_preview)
        ivPreview.setOnClickListener {
            onItemClickListener?.onClick(position)
        }
        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_default_pic).error(R.drawable.ic_default_pic)
        Glide.with(mContext).load(mDatas[position]).apply(requestOptions).into(ivPreview)
        return viewRoot
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    interface OnItemClickListener{
        fun onClick(position: Int)
    }

}