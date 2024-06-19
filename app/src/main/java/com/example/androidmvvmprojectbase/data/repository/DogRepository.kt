package com.example.androidmvvmprojectbase.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.androidmvvmprojectbase.base.BaseRepository
import com.example.androidmvvmprojectbase.base.DataState
import com.example.androidmvvmprojectbase.data.Dog
import com.example.androidmvvmprojectbase.data.source.local.DogDao
import com.example.androidmvvmprojectbase.data.source.local.toListDog
import com.example.androidmvvmprojectbase.data.source.local.toLocalDog
import com.example.androidmvvmprojectbase.data.source.network.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DogRepository(
    private val dogDao: DogDao,
    private val apiService: APIService,
    private val scope: CoroutineScope = GlobalScope
) : BaseRepository() {

    fun getAllDog(): LiveData<List<Dog>> {
        return dogDao.getAllDog().map { it.toListDog() }
    }

    suspend fun refresh(): DataState<List<Dog>> {
        val response = getResult { apiService.getAllDog() }
        if (response is DataState.Success) {
            val networkDogs = response.data
            networkDogs.forEach {
                getResult { dogDao.upsertDog(it.toLocalDog()) }
            }
        }
        return response
    }

    suspend fun createDog(newDog: Dog) {
        dogDao.createDog(newDog.toLocalDog())
        scope.launch {
            when (val request = getResult { apiService.createDog(newDog) }) {
                is DataState.Success -> {
                    Log.i("Dog Repository", "Saved to network successfully!")
                }

                is DataState.Error -> {
                    Log.e("Dog Repository", "${request.exception}")
                }
            }
        }
    }
}