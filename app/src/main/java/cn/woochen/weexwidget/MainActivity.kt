package cn.woochen.weexwidget

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import cn.woochen.weexwidget.adapter.MainAdapter
import cn.woochen.weexwidget.samples.JumpActivity
import cn.woochen.weexwidget.utils.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var exitTime: Long = 0

    private val mItemNames = mutableListOf("测试")
    private val mMainAdapter by lazy {
        MainAdapter(this,mItemNames)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    private fun initData() {

    }

    private fun initView() {
        rv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL,false)
        rv.adapter = mMainAdapter
        mMainAdapter.itemClickListener = object: MainAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                itemClickEvent(position)
            }
        }

    }

    private fun itemClickEvent(position: Int) {
        when (position) {
            0 -> {
                start(JumpActivity::class.java)
            }
        }
    }


    private fun start(clazz:Class<*>){
        val intent = Intent(this,clazz)
        startActivity(intent)

    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - exitTime > 2000) {
            toast(this,"再按一下退出程序")
            exitTime = System.currentTimeMillis()
        } else {
            finish()
            System.exit(0)
        }
    }


}
