package fanjie.com.takeout.ui.fragment

import android.view.View
import fanjie.com.takeout.R
import fanjie.com.takeout.ui.activity.LoginActivity
import fanjie.com.takeout.utils.SpUtils
import kotlinx.android.synthetic.main.fragment_my.*
import org.jetbrains.anko.startActivity

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/23 15:41
 * Notes: 个人界面的
 */
class MyFragment : BaseFragment() {



    override fun getLayoutResId(): Int {
        return R.layout.fragment_my
    }

    override fun initData() {
        super.initData()



        login.setOnClickListener {
            context!!.startActivity<LoginActivity>()
        }


    }

    override fun onStart() {
        super.onStart()

        val SPname = SpUtils.getInstance("user").getString("name")
        val SPphone = SpUtils.getInstance("user").getString("phone")
        val isLogin = SpUtils.getInstance("user").getBoolean("isLogin")

        if (isLogin) {
            //登录状态
            login.visibility = View.GONE
            ll_userinfo.visibility = View.VISIBLE
            username.text = SPname
            phone.text = SPphone
        } else {
            //未登录
            ll_userinfo.visibility = View.GONE
            login.visibility = View.VISIBLE

        }

    }
}