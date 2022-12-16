package com.bhola.example.myapplication.datasource

import com.bhola.example.myapplication.datasource.model.BaseStateResponse
import com.bhola.example.myapplication.features.todo.model.Todo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class TodoDataSource(private val dispatcher: CoroutineDispatcher, private val networkRepo: NetworkRepo) {

    suspend fun execute(): BaseStateResponse<Todo> {
        return try {
            withContext(dispatcher) {
                networkRepo.getDetail().let {
                    BaseStateResponse(it)
                }
            }
        } catch (e: Exception) {
            BaseStateResponse(e)
        }
    }
}