package com.bhola.example.myapplication.datasource

object DataSourceConfig {
    fun checkBoolean(value: String?): Boolean {
        return value?.let {
            "y".equals(it, ignoreCase = true) || "true".equals(it, ignoreCase = true)
        } ?: false
    }
}