package com.geeks.lovecalculate.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geeks.lovecalculate.data.local.dao.LoveDao
import com.geeks.lovecalculate.data.local.entities.History

@Database(entities = [History::class], version = 1)
abstract class LoveDatabase : RoomDatabase() {
    abstract fun dao(): LoveDao
}