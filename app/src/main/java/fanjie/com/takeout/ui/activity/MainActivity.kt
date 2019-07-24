package fanjie.com.takeout.ui.activity

import fanjie.com.takeout.R
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

        bottomBar.setOnTabSelectListener { tabId: Int ->
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_frame, FragmentFactory.instance.getFragment(tabId)!!)
            transaction.commit()
        }
    }
}
