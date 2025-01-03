package com.ndmq.android_mvvm_project_base.di

import com.ndmq.android_mvvm_project_base.data.source.remote.APIService
import com.ndmq.android_mvvm_project_base.utils.constant.APIConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataSourceModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder().apply {
            connectTimeout(APIConstants.TimeOut.CONNECT_TIME_OUT, TimeUnit.SECONDS)
            readTimeout(APIConstants.TimeOut.READ_TIME_OUT, TimeUnit.SECONDS)
            addInterceptor(interceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(APIConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideAPIService(retrofit: Retrofit): APIService {
        return retrofit.create(APIService::class.java)
    }
}