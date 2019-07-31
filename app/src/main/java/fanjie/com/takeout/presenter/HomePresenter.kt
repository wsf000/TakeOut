package fanjie.com.takeout.presenter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fanjie.com.takeout.contract.HomeContract
import fanjie.com.takeout.model.Seller
import fanjie.com.takeout.net.NetPresenter
import org.json.JSONObject

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/25 17:10
 * Notes: 首页的逻辑类
 */
class HomePresenter(val view : HomeContract.HomeView) : HomeContract.HomePresenter , NetPresenter() {

    override fun HomeLoadInfo() {
        view.StartLoadInfo()
        //TODO:要异步访问
        val homeInfo = takeoutService.getHomeInfo()
        homeInfo.enqueue(callback)

    }

    override fun parserJson(json: String) {

//        val seller = Gson().fromJson(json, Seller::class.java)

        val gson = Gson()
        val jsonObject = JSONObject(json)
        val nearby = jsonObject.getString("nearbySellerList")
        val nearbySellers: List<Seller> = gson.fromJson(nearby, object : TypeToken<List<Seller>>() {}.type)
        val other = jsonObject.getString("otherSellerList")
        val otherSellers: List<Seller> = gson.fromJson(other, object : TypeToken<List<Seller>>() {}.type)


        if (nearbySellers.isNotEmpty() || otherSellers.isNotEmpty()) {
            view.HomeLoadSuccess(nearbySellers,otherSellers)
        } else {
            view.HomeLoadFailed()
        }

    }
}