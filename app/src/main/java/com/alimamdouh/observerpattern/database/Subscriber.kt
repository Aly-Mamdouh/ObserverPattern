package com.alimamdouh.observerpattern.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SUBS_TABLE")
data class Subscriber(
   @PrimaryKey(autoGenerate = true) var id:Int,
   var proName:String,
   var subsName:String
)
