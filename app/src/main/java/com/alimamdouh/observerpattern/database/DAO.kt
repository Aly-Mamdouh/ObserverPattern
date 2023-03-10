package com.alimamdouh.observerpattern.database

import androidx.room.*

@Dao
interface DAO {

    @Insert
    fun insertSubs(subscriber: Subscriber)

    @Query("delete from SUBS_TABLE where subsName=:name")
    fun deleteSubs(name: String)

    @Query("select * from SUBS_TABLE")
    fun getAllSubs():List<Subscriber>
}