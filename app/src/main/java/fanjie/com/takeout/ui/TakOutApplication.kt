package fanjie.com.takeout.ui

import android.app.Application

/**
 * Project Name:
 * Author:wsf
 * Date: 2019/7/31 10:05
 * Notes:
 */

class TakOutApplication : Application() {

    companion object {
        lateinit var instace  : TakOutApplication
    }


    override fun onCreate() {
        super.onCreate()

        instace = this

    }


}