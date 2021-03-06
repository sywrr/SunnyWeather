package com.sunnyweater.android.logic.network

import com.sunnyweater.android.SunnyWeatherApplication
import com.sunnyweater.android.logic.model.PlaceResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * 用于访问彩云天气城市搜索API的Retrofit接口
 */
interface PlaceService {
    //相对路径
    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    fun searchPlaces(@Query("query") query:String) : Call<PlaceResponse>
}