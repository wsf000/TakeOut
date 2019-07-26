package fanjie.com.takeout.contract

import fanjie.com.takeout.model.Seller

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/25 17:07
 * Notes: 首页界面的mvp协议类
 */
interface HomeContract {


    interface HomePresenter {

        fun HomeLoadInfo()
    }

    interface  HomeView {
        fun StartLoadInfo()
        fun HomeLoadFailed()
        fun HomeLoadSuccess(nearbySellers: List<Seller>, otherSellers: List<Seller>)
    }
}