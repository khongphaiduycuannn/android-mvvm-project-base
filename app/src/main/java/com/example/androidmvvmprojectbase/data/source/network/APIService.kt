package com.example.androidmvvmprojectbase.data.source.network

import com.example.androidmvvmprojectbase.data.User
import com.example.androidmvvmprojectbase.utils.constant.APIConstant
import retrofit2.http.GET
import retrofit2.http.Header

interface APIService {

    @GET(APIConstant.EndPoint.USER)
    suspend fun getAllUser(): List<User>
}