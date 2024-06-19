package com.example.androidmvvmprojectbase.data.repository

import com.example.androidmvvmprojectbase.base.BaseRepository
import com.example.androidmvvmprojectbase.data.source.network.APIService

class UserRepository(
    private val apiService: APIService
) : BaseRepository() {

    suspend fun getAllUser() = getResult {
        apiService.getAllUser()
    }
}