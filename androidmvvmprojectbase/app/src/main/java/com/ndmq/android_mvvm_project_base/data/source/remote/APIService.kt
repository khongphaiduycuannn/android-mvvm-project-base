package com.ndmq.android_mvvm_project_base.data.source.remote

import com.ndmq.android_mvvm_project_base.data.model.Member
import com.ndmq.android_mvvm_project_base.utils.constant.APIConstants
import retrofit2.http.GET

interface APIService {

    @GET(APIConstants.EndPoint.GET_ALL_MEMBERS)
    suspend fun getAllMembers(): List<Member>
}