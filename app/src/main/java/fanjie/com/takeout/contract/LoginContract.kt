package fanjie.com.takeout.contract

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/29 10:27
 * Notes:登录界面的mvp
 */
interface LoginContract  {


    interface LoginPresenter {
       fun login(mPhone : String, mCode : String)
    }

    interface LoginView{
        fun LoginSuncess()
        fun LoginFailed()
    }

}