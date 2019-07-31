package fanjie.com.takeout.presenter

import android.util.Log
import com.google.gson.Gson
import fanjie.com.takeout.contract.LoginContract
import fanjie.com.takeout.model.User
import fanjie.com.takeout.net.NetPresenter
import fanjie.com.takeout.utils.SpUtils


/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/29 10:45
 * Notes:
 */
class LoginPresenter (val view :LoginContract.LoginView) :LoginContract.LoginPresenter , NetPresenter() {


    override fun login(mPhone: String, mCode: String) {


        //登录逻辑处理
        val loginByPhone = takeoutService.loginByPhone(mPhone)
        loginByPhone.enqueue(callback)


    }

    override fun parserJson(json: String) {
        val user = Gson().fromJson(json, User::class.java)
        Log.e("---user信息：" , user.toString() )
        if (user != null) {
            SpUtils.getInstance("user").put("name",user.name)
            SpUtils.getInstance("user").put("phone",user.phone)
            SpUtils.getInstance("user").put("isLogin",true)
            view.LoginSuncess()
        } else {
            view.LoginFailed()
        }







    }
}