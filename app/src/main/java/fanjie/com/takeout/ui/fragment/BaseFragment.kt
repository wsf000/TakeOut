package fanjie.com.takeout.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/23 14:32
 * Notes:
 */
abstract class BaseFragment : Fragment(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutResId(), null)
    }

    abstract fun getLayoutResId(): Int

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initData()
    }

    open fun initData() {
    }

}