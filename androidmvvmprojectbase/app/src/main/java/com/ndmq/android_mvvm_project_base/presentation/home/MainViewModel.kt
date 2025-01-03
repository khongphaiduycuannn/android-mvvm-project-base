package com.ndmq.android_mvvm_project_base.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ndmq.android_mvvm_project_base.base.BaseViewModel
import com.ndmq.android_mvvm_project_base.base.DataState
import com.ndmq.android_mvvm_project_base.data.model.Member
import com.ndmq.android_mvvm_project_base.data.repository.MemberRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val memberRepository: MemberRepository
) : BaseViewModel() {

    val allMembers: LiveData<List<Member>> = memberRepository.allMembersLocal.asLiveData()

    fun pullRemoteData() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val dataState = memberRepository.getAllMembersRemote()) {
                is DataState.Success -> {
                    memberRepository
                        .saveMembersToLocal(dataState.data)
                }

                is DataState.Error -> {
                    error.postValue(dataState.exception)
                }
            }
        }
    }
}