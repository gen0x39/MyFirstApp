package com.example.myfirstapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayCallDao {
    @Query("SELECT * FROM play_calls")
    suspend fun loadAllPlayCall(): List<PlayCallEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePlayCall(playCallEntity: PlayCallEntity)
}