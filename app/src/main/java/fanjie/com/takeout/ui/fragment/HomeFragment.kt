package fanjie.com.takeout.ui.fragment

import android.graphics.Color
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import fanjie.com.takeout.R
import fanjie.com.takeout.adapter.HomeAdapter
import fanjie.com.takeout.contract.HomeContract
import fanjie.com.takeout.model.Seller
import fanjie.com.takeout.presenter.HomePresenter
import fanjie.com.takeout.utils.AllUtils
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/23 15:41
 * Notes:
 */
class HomeFragment : BaseFragment() ,HomeContract.HomeView{

    val datas = mutableListOf<Seller>()

    var sum: Int = 0
    var distance : Int = 0
    var alpha : Int= 55

    val presenter by lazy {
        HomePresenter(this)
    }

    override fun getLayoutResId(): Int {
        return R.layout.fragment_home
    }

    override fun initData() {
        presenter.HomeLoadInfo()

        //轮播图的高度减去渐变区的高度 200 - 80
        distance = AllUtils.dip2px(context, 120F)



        rv_home.apply {
            rv_home.setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            rv_home.adapter = HomeAdapter(context, datas)
        }

        rv_home.setOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {

            }

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                //滑动监听
                sum += dy
                if (sum > distance) {
                    alpha = 255
                } else {
                    alpha = sum * 200 / distance
                    alpha += 55
                }

                ll_title_container.setBackgroundColor(Color.argb(alpha,0x31,0x90,0xe8))

            }
        })
    }

    override fun StartLoadInfo() {
        //开始加载数据
        showProgress("开始加载")

    }


    override fun HomeLoadSuccess(nearbySellers: List<Seller>, otherSellers: List<Seller>) {
        dismissProgress()
        datas.clear()
        datas.addAll(nearbySellers)
        datas.addAll(otherSellers)

    }

    override fun HomeLoadFailed() {
        dismissProgress()
        toast("获取数据失败")

    }
}