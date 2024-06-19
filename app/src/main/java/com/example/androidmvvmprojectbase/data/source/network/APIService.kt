package com.example.androidmvvmprojectbase.data.source.network

import com.example.androidmvvmprojectbase.data.Dog
import com.example.androidmvvmprojectbase.utils.constant.APIConstant
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface APIService {

    @GET(APIConstant.EndPoint.DOG)
    suspend fun getAllDog(): List<Dog>

    @GET(APIConstant.EndPoint.DOG_BY_ID)
    suspend fun getDogById(@Path("id") id: String): Dog

    @POST(APIConstant.EndPoint.DOG)
    suspend fun createDog(@Body dog: Dog)

    @PUT(APIConstant.EndPoint.DOG_BY_ID)
    suspend fun updateDog(@Path("id") id: String, @Body dog: Dog)

    @DELETE(APIConstant.EndPoint.DOG_BY_ID)
    suspend fun deleteDog(@Path("id") id: String)
}