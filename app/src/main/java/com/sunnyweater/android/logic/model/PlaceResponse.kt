package com.sunnyweater.android.logic.model

import com.google.gson.annotations.SerializedName

/**
 * 提供数据模型
 */
data class PlaceResponse(val status:String,val places:List<Place>)

data class Place(val name:String,val location:Location,@SerializedName("formatted_adress")val  adress :String)

data class Location(val lng :String,val lat:String)