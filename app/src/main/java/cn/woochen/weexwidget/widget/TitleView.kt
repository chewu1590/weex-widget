package cn.woochen.weexwidget.widget

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import cn.woochen.weexwidget.R

/**
 *头部标题
 *@author woochen
 *@time 2018/11/14 16:54
 */
class TitleView : RelativeLayout, View.OnClickListener {


    private val mLeftIcon: Int
    private val mRightIcon: Int
    private val title: CharSequence
    private val mRightTitle: CharSequence
    var titleListner: OnTitleClickListener? = null
    private var mTitleSize: Float = 17f
    private var mRightTitleSize: Float = 17f
    private var mTitleColor: Int
    private var mRightTitleColor: Int

    interface OnTitleClickListener {
        fun leftClick()
        fun rightClick()
    }

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)


    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        val typedArray = context?.obtainStyledAttributes(attrs, R.styleable.TitleView)
        mLeftIcon = typedArray!!.getResourceId(R.styleable.TitleView_left_icon, 0)
        mRightIcon = typedArray.getResourceId(R.styleable.TitleView_right_icon, 0)
        title = typedArray.getText(R.styleable.TitleView_title_name)
        mTitleColor = typedArray.getResourceId(R.styleable.TitleView_title_color, 0)
        mTitleSize = typedArray.getFloat(R.styleable.TitleView_title_size, mTitleSize)
        mRightTitle = typedArray.getText(R.styleable.TitleView_right_text)
        mRightTitleColor = typedArray.getResourceId(R.styleable.TitleView_right_text_color, 0)
        mRightTitleSize = typedArray.getFloat(R.styleable.TitleView_right_text_size, mRightTitleSize)
        typedArray.recycle()
    }

    private var mTitle: TextView? = null
    private var tv_right_txt: TextView? = null

    override fun onFinishInflate() {
        super.onFinishInflate()
        View.inflate(context, R.layout.view_title, this)
        val leftIcon = this.findViewById<ImageView>(R.id.iv_left_icon)
        mTitle = this.findViewById(R.id.tv_center_title)
        tv_right_txt = this.findViewById(R.id.tv_right_txt)
        val rightIcon = this.findViewById<ImageView>(R.id.iv_right_icon)
        leftIcon.setOnClickListener(this)
        rightIcon.setOnClickListener(this)
        tv_right_txt?.setOnClickListener(this)
        if (mLeftIcon > 0) {
            leftIcon.visibility =View.VISIBLE
            leftIcon.setImageResource(mLeftIcon)
        }else{
            leftIcon.visibility =View.GONE
        }
        mTitle?.visibility = if (!title.isEmpty()) {
            if (mTitleSize > 0) mTitle?.textSize = mTitleSize
            mTitle?.text = title
            if (mTitleColor > 0) mTitle?.setTextColor(resources.getColor(mTitleColor))
            View.VISIBLE
        } else View.GONE
        //right txt
        if (mRightTitleColor > 0) tv_right_txt?.setTextColor(resources.getColor(mRightTitleColor)) else tv_right_txt?.setTextColor(Color.WHITE)
        tv_right_txt?.visibility = if (!TextUtils.isEmpty(mRightTitle)) {
            if (mRightTitleSize > 0) tv_right_txt?.textSize = mRightTitleSize
            tv_right_txt?.text = mRightTitle
            View.VISIBLE
        } else View.GONE
        rightIcon.visibility = if (mRightIcon != 0) {
            rightIcon.setImageResource(mRightIcon)
            View.VISIBLE
        } else View.GONE
    }

    override fun onClick(v: View?) {
        if (titleListner == null) {
            when (v!!.id) {
                R.id.iv_left_icon -> toBack()
            }
            return
        }
        titleListner?.apply {
            when (v!!.id) {
                R.id.iv_left_icon -> leftClick()
                R.id.iv_right_icon -> rightClick()
                R.id.tv_right_txt -> rightClick()
            }
        }

    }


    private fun toBack() {
        (context as? Activity)?.finish()
    }


    fun setTitle(title: String) {
        mTitle?.text = title
    }

    fun setTitle(titleResId: Int) {
        mTitle?.setText(titleResId)
    }

    fun setRightText(content: String) {
        if (tv_right_txt?.visibility != View.VISIBLE) tv_right_txt?.visibility = View.VISIBLE
        tv_right_txt?.text = content
    }

}