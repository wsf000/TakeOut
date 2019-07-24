package fanjie.com.takeout.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import fanjie.com.takeout.R
import fanjie.com.takeout.adapter.HomeAdapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/23 15:41
 * Notes:
 */
class HomeFragment : BaseFragment() {

    val datas  = mutableListOf<String>()

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {

        for (i in 0 until 100) {
            datas.add("我湿商家$i")
        }



        rv_home.apply {
            rv_home.setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            rv_home.adapter = HomeAdapter(context,datas)

        }
    }




}