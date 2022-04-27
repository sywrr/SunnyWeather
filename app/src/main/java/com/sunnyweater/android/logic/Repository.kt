package com.sunnyweater.android.logic

import androidx.lifecycle.liveData
import com.sunnyweater.android.logic.model.Place
import com.sunnyweater.android.logic.network.PlaceService
import com.sunnyweater.android.logic.network.SunnyWeatherNetWork
import kotlinx.coroutines.Dispatchers
import java.lang.Exception
import java.lang.RuntimeException

/*
*
*仓库层的统一封装入口
*/

object Repository {

    //返回一个包含PlaceResponse数据的liveData对象
    fun searchPlaces(query:String) = liveData(Dispatchers.IO){

        val result =try {
            //搜索城市数据
            val placeResponse =SunnyWeatherNetWork.searchPlaces(query)
            if(placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        //类似调用LiveData的setValue()方法来通知数据变化
        emit(result)
    }
}