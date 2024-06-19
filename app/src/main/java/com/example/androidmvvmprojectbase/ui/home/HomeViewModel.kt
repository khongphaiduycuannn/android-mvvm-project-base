package com.example.androidmvvmprojectbase.ui.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.androidmvvmprojectbase.MyApplication
import com.example.androidmvvmprojectbase.base.BaseViewModel
import com.example.androidmvvmprojectbase.base.DataState
import com.example.androidmvvmprojectbase.data.User
import com.example.androidmvvmprojectbase.data.repository.UserRepository
import com.example.androidmvvmprojectbase.data.source.network.APIService
import com.example.androidmvvmprojectbase.data.source.network.RetrofitClient
import kotlinx.coroutines.delay

class HomeViewModel : BaseViewModel() {

    val number = MutableLiveData<Int>()

    val userList = MutableLiveData<List<User>>()

    private val userRepository = UserRepository(
        RetrofitClient.getInstance().create(APIService::class.java)
    )

    fun getNumber() {
        executeTask(
            request = { getNetworkNumber() },
            onSuccess = {
                number.value = it
            },
            onError = {
                Toast.makeText(MyApplication.context, "${it.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    fun getUserList() {
        executeTask(
            request = { userRepository.getAllUser() },
            onSuccess = {
                userList.value = it
            },
            onError = {
                Toast.makeText(MyApplication.context, "${it.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }

    suspend fun getNetworkNumber(): DataState<Int> {
        delay(5000)
        return DataState.Success(5)
    }
}