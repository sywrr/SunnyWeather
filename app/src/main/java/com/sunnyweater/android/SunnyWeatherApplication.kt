package com.sunnyweater.android

import android.app.Application
import android.content.Context

class SunnyWeatherApplication :Application(){

    companion object{
        const val TOKEN ="jGViZoPGdLOOsxgI"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context =applicationContext
    }
}