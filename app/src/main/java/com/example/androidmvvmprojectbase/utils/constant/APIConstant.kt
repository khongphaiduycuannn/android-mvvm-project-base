package com.example.androidmvvmprojectbase.utils.constant

object APIConstant {

    const val BASE_URL = "https://663b532dfee6744a6ea139c8.mockapi.io/api/"

    object EndPoint {
        const val DOG = "dog"
        const val DOG_BY_ID = "dog/{id}"

        const val USER = "user"
        const val USER_BY_ID = "user/{id}"
    }

    object TimeOut {
        const val CONNECT_TIME_OUT = 20L
    }
}