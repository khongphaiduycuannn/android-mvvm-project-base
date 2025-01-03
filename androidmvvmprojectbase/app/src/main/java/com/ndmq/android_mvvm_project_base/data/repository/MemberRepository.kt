package com.ndmq.android_mvvm_project_base.data.repository

import com.google.gson.Gson
import com.ndmq.android_mvvm_project_base.base.BaseRepository
import com.ndmq.android_mvvm_project_base.data.model.Member
import com.ndmq.android_mvvm_project_base.data.source.local.RoomDao
import com.ndmq.android_mvvm_project_base.data.source.remote.APIService
import com.ndmq.android_mvvm_project_base.utils.constant.AppConstants
import com.tencent.mmkv.MMKV
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MemberRepository @Inject constructor(
    private val remote: APIService,
    private val local: RoomDao,
    private val cache: MMKV
) : BaseRepository() {

    val allMembersLocal: Flow<List<Member>> = local.getAllMembers()

    suspend fun saveMembersToLocal(members: List<Member>) = getResult {
        local.updateMembers(members)
    }

    suspend fun saveMembersToCache(members: List<Member>) = getResult {
        val decodedList = Gson().toJson(members)
        cache.decodeString(AppConstants.MEMBERS_CACHE, decodedList)
    }

    suspend fun getAllMembersRemote() = getResult {
        remote.getAllMembers()
    }
}