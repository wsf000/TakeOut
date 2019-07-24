package fanjie.com.takeout.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import fanjie.com.takeout.R

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

    fun bindview(s: String) {


    }

}