package com.bhola.example.myapplication.datasource

import com.bhola.example.myapplication.features.todo.model.Todo
import io.reactivex.Single
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NetworkApi {
    @GET("/todos")
    fun getTodos() : Single<List<Todo>>
    @GET("/todos")
    fun getTodoDetail() : Call<Todo>

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun create(): NetworkApi {
            val client = OkHttpClient.Builder().build()
            return Retrofit.Builder()
                .baseUrl(HttpUrl.parse(BASE_URL)!!)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkApi::class.java)
        }
    }
}