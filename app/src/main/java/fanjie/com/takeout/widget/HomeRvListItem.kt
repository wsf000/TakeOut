package fanjie.com.takeout.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.squareup.picasso.Picasso
import fanjie.com.takeout.R
import fanjie.com.takeout.model.Seller
import kotlinx.android.synthetic.main.item_seller.view.*

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/24 14:11
 * Notes:
 */
class HomeRvListItem(context: Context?, attrs: AttributeSet? = null) : RelativeLayout(context, attrs) {


    init {
        View.inflate(context, R.layout.item_seller,this)
    }

    fun bindview(s: Seller) {

        tv_title.text = s.name
        Picasso.with(context).load(s.icon).into(seller_logo)
        tv_home_sale.text= "月售${s.sale}单"
        tv_home_send_price.text = "￥${s.sendPrice}起送/配送费￥${s.deliveryFee}"
        tv_home_distance.text = s.distance



    }

}