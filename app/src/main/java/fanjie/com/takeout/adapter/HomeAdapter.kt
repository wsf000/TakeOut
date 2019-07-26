package fanjie.com.takeout.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import fanjie.com.takeout.model.Seller
import fanjie.com.takeout.widget.HomeRvListItem
import fanjie.com.takeout.widget.HomeTitleItem

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/24 13:50
 * Notes: 首页适配器
 */
class HomeAdapter(val context: Context, val mDatas: MutableList<Seller>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        val TYPE_HOME_TITLE = 0
        val TYPE_HOME_RV = 1
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return TYPE_HOME_TITLE
        } else {
            return TYPE_HOME_RV
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == TYPE_HOME_TITLE) {
            HometTitleHodler(HomeTitleItem(context))
        } else {
            HomeRVHodler(HomeRvListItem(context))
        }

    }

    override fun getItemCount(): Int {
        if (mDatas.size > 0){
            return mDatas.size +1
        } else{
            return  0
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val viewType = getItemViewType(position)

        when(viewType) {
            TYPE_HOME_TITLE -> {
                val item = holder.itemView as HomeTitleItem
                item.bindview("我湿大哥大第一个")
            }
            TYPE_HOME_RV -> {
                val item = holder.itemView as HomeRvListItem
                item.bindview(mDatas[position - 1])
                item.setOnClickListener {

                }
            }
        }



    }


    class HometTitleHodler(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    }

    class HomeRVHodler(itemView: View?) : RecyclerView.ViewHolder(itemView) {


    }
}