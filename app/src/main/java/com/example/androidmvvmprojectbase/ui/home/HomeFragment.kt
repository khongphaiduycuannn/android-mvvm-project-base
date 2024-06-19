package com.example.androidmvvmprojectbase.ui.home

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmvvmprojectbase.base.BaseFragment
import com.example.androidmvvmprojectbase.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this)[HomeViewModel::class]

    private val userAdapter = UserAdapter()

    override fun initData() {
        viewModel.getUserList()
    }

    override fun bindData() {
        binding.rclUserList.adapter = userAdapter
        binding.rclUserList.layoutManager = LinearLayoutManager(context)
    }

    override fun observeData() {
        viewModel.number.observe(viewLifecycleOwner) {
            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
        }

        viewModel.userList.observe(viewLifecycleOwner) {
            userAdapter.setDataList(it.toMutableList())
        }
    }

    override fun setOnClick() {

    }
}