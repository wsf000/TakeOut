package fanjie.com.takeout.ui.activity

import fanjie.com.takeout.R
import fanjie.com.takeout.utils.AllUtils
import fanjie.com.takeout.widget.FragmentFactory
import kotlinx.android.synthetic.main.activity_main.*

/**
 *
 */

class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initData() {
        super.initData()

        initBottom()
        initSystem()
    }

    private fun initSystem() {
        //判断底部是否有虚拟按键，如果有的话mainactivity底部加50dp
        if (AllUtils.checkDeviceHasNavigationBar(this)) {
            ll_main_activity.setPadding(0, 0, 0, AllUtils.dip2px(this, 50.0F))
        }


    }

    private fun initBottom() {
        bottomBar.setOnTabSelectListener { tabId: Int ->
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_frame, FragmentFactory.instance.getFragment(tabId)!!)
            transaction.commit()
        }
    }

}
