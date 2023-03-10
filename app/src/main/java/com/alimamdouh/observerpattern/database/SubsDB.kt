package com.alimamdouh.observerpattern.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Subscriber::class], version = 1)
abstract class SubsDB : RoomDatabase() {
    abstract fun dao(): DAO

    companion object {
        const val DB_NAME = "MyDb"
        @Volatile
        private var instance: SubsDB? = null

        fun getInstance(context: Context): SubsDB {
            return instance ?: synchronized(this) { buildDB(context).also { instance = it } }
        }

        private fun buildDB(context: Context): SubsDB {
            return Room.databaseBuilder(context, SubsDB::class.java, DB_NAME).allowMainThreadQueries().build()
        }
    }
}