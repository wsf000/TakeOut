package fanjie.com.takeout.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/23 14:31
 * Notes:
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initData()
    }

   open  fun initData() {

    }

    abstract fun getLayoutId(): Int


}