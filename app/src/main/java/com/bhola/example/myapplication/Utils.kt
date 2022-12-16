package com.bhola.example.myapplication

import androidx.annotation.VisibleForTesting
import com.bhola.example.myapplication.datasource.DataSourceConfig

class Utils {
    /**
     * comma separated unique ids
     */
    @VisibleForTesting
    fun getUniqueIds(list: List<String?>?): String {
        return list?.filterNotNull()?.distinct()?.joinToString(",").orEmpty()
    }

    @VisibleForTesting
    fun getIds(list: List<String?>?): String {
        return list?.joinToString(",").orEmpty()
    }

    fun convertToString(allowDuplicates: String?, list: List<String?>?): String {
        //complexity 1
        return if (DataSourceConfig.checkBoolean(allowDuplicates)) {
            //complexity 2
            getUniqueIds(list)
        } else {
            //complexity 3
            getIds(list)
        }
    }
}
