package fanjie.com.takeout.ui.activity

import fanjie.com.takeout.R
import fanjie.com.takeout.contract.LoginContract
import fanjie.com.takeout.presenter.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/26 17:10
 * Notes:
 */
class LoginActivity : BaseActivity(), LoginContract.LoginView {


    val presenter by lazy {
        LoginPresenter(this)
    }


    override fun getLayoutId(): Int =
        R.layout.activity_login

    override fun initData() {

        init()


    }

    private fun init() {


        iv_user_back.setOnClickListener { finish() }
        tv_user_code.setOnClickListener {


        }
        iv_login.setOnClickListener {
            val phone = et_user_phone.text.toString().trim()
            val code = et_user_code.text.trim().toString()
//            if (SMSUtil.judgePhoneNums(this,phone) && TextUtils.isEmpty(code)) {
//
//
//                toast("号码和验证码都不能为空")
//            } else {
//                presenter.login(phone, code)
//
//            }
            presenter.login(phone,code)


        }

    }

    override fun LoginSuncess() {

        toast("登录成功")
        finish()


    }

    override fun LoginFailed() {

        toast("登录失败")
    }
}