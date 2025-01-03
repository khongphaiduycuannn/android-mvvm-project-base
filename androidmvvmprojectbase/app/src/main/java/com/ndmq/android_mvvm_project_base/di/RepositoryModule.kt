package com.ndmq.android_mvvm_project_base.di

import com.ndmq.android_mvvm_project_base.data.repository.MemberRepository
import com.ndmq.android_mvvm_project_base.data.source.local.RoomDao
import com.ndmq.android_mvvm_project_base.data.source.remote.APIService
import com.tencent.mmkv.MMKV
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMemberRepository(apiService: APIService, local: RoomDao): MemberRepository {
        return MemberRepository(apiService, local, MMKV.defaultMMKV())
    }
}