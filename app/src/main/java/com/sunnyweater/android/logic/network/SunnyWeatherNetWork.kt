package com.sunnyweater.android.logic.network

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * 统一数据访问入口，对网络请求的API进行封装
 */
object SunnyWeatherNetWork {

    //创建PlaceService 接口的动态代理对象
    private val placeService=ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query:String)= placeService.searchPlaces(query).await()

    suspend fun <T> Call<T>.await() : T {

        return suspendCoroutine {

            continuation ->   println("suspendCoroutine thread name: ${Thread.currentThread().name}")
            enqueue(object :Callback<T>{
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                if(body!=null){
                    continuation.resume(body)
                }else{
                    continuation.resumeWithException(RuntimeException("response body is null"))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resumeWithException(t)
            }

        })
        }
    }
}