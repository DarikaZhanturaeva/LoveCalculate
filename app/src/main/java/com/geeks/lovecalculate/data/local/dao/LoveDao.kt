package com.geeks.lovecalculate.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.geeks.lovecalculate.data.local.entities.History

@Dao
interface LoveDao {

    @Insert
    fun insertHistory(historyEntity: History)

    @Query(" SELECT * FROM histories ORDER by first_name ")
    fun sortAll(): LiveData<List<History>>

    @Delete
    fun deleteHistory(history: History)
}