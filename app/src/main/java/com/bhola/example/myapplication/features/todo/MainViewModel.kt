package com.bhola.example.myapplication.features.todo

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.bhola.example.myapplication.datasource.NetworkDataSource


class MainViewModel(private val dataSource:NetworkDataSource) : ViewModel() {

    val response = MediatorLiveData<Int>()

    fun execute(input:String?) {
        if (dataSource.isValid(input)){
            response.postValue(2)
        }else{
            response.postValue(3)
        }
    }

    fun execute1(input:String?) {
        if (dataSource.isValid(input)){
            getLiveData().postValue(2)
        }else{
            getLiveData().postValue(3)
        }
    }
    fun getLiveData(): MediatorLiveData<Int> {
        return response
    }
}