package com.example.androidmvvmprojectbase.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.androidmvvmprojectbase.MyApplication
import com.example.androidmvvmprojectbase.base.BaseViewModel
import com.example.androidmvvmprojectbase.data.Dog
import com.example.androidmvvmprojectbase.data.repository.DogRepository
import com.example.androidmvvmprojectbase.data.source.local.DogRoomDatabase
import com.example.androidmvvmprojectbase.data.source.network.APIService
import com.example.androidmvvmprojectbase.data.source.network.RetrofitClient

class HomeViewModel : BaseViewModel() {

    private val dogRepository = DogRepository(
        DogRoomDatabase.getDatabase(MyApplication.context).dogDao(),
        RetrofitClient.getInstance().create(APIService::class.java)
    )

    val dogList: LiveData<List<Dog>> = dogRepository.getAllDog()

    fun refreshData() {
        executeTask(
            request = {
                dogRepository.refresh()
            },
            onSuccess = {
                Log.d("HomeViewModel", it.toString())
            },
            onError = {
                Log.e("HomeViewModel", "${it.message}")
            },
            showLoading = true
        )
    }
}