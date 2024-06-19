package com.example.androidmvvmprojectbase.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert

@Dao
interface DogDao {

    @Query("SELECT * FROM dog")
    fun getAllDog(): LiveData<List<LocalDog>>

    @Query("SELECT * FROM dog WHERE id = :id")
    suspend fun getDogById(id: String): LocalDog

    @Insert
    suspend fun createDog(dog: LocalDog)

    @Update
    suspend fun updateDog(dog: LocalDog)

    @Upsert
    suspend fun upsertDog(dog: LocalDog)

    @Query("DELETE FROM dog WHERE id = :id")
    suspend fun delete(id: String)
}