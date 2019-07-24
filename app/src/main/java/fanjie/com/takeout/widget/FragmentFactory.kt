package fanjie.com.takeout.widget

import android.support.v4.app.Fragment
import fanjie.com.takeout.R
import fanjie.com.takeout.ui.fragment.HomeFragment
import fanjie.com.takeout.ui.fragment.MoreFragment
import fanjie.com.takeout.ui.fragment.MyFragment
import fanjie.com.takeout.ui.fragment.OrdersFragment

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/23 15:36
 * Notes:
 */
class FragmentFactory private constructor(){



    val home by lazy {
        HomeFragment()
    }
    val orders by lazy {
        OrdersFragment()
    }
    val my by lazy {
        MyFragment()
    }
    val more by lazy {
        MoreFragment()
    }





    companion object {
        val instance = FragmentFactory()
    }

    fun getFragment(tabId :Int) : Fragment?{

        when(tabId) {
            R.id.tab_home -> return  home
            R.id.tab_orders -> return  orders
            R.id.tab_my -> return  my
            R.id.tab_more -> return  more
        }

        return  null
    }
}