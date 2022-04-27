package com.sunnyweater.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.sunnyweater.android.logic.Repository
import com.sunnyweater.android.logic.model.Place

class PlaceViewModel:ViewModel() {

    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiveData = Transformations.switchMap(searchLiveData){
        qurery -> Repository.searchPlaces(qurery)
    }
    fun searchPlaces(query:String){
        searchLiveData.value =query
    }
}