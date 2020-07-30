package com.example.myfirstapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PlayCallEntity::class], version = 1, exportSchema = false)
abstract class  AppDatabase : RoomDatabase() {
    abstract fun playCallDao(): PlayCallDao
}