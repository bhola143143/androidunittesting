package com.bhola.example.myapplication.datasource

import com.bhola.example.myapplication.features.todo.model.Todo

class NetworkRepo {

    fun getDetail(): Todo {
        return getApi().getTodoDetail().execute().body()!!
    }

    private fun getApi(): NetworkApi {
        return NetworkApi.create()
    }
}
