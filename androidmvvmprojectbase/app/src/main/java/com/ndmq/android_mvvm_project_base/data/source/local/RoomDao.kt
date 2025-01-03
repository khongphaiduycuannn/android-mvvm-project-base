package com.ndmq.android_mvvm_project_base.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.ndmq.android_mvvm_project_base.data.model.Member
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

    @Query("select * from Member")
    fun getAllMembers(): Flow<List<Member>>

    @Upsert
    suspend fun updateMember(member: Member)

    @Transaction
    suspend fun updateMembers(members: List<Member>) {
        members.forEach { updateMember(it) }
    }
}