package com.ndmq.android_mvvm_project_base.di

import android.content.Context
import com.ndmq.android_mvvm_project_base.data.source.local.AppRoomDatabase
import com.ndmq.android_mvvm_project_base.data.source.local.RoomDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideDao(
        @ApplicationContext context: Context
    ): RoomDao {
        return AppRoomDatabase.getDatabase(context).roomDao
    }
}