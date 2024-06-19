package com.example.androidmvvmprojectbase.ui.home

import com.example.androidmvvmprojectbase.base.BaseAdapter
import com.example.androidmvvmprojectbase.data.User
import com.example.androidmvvmprojectbase.databinding.ItemUserBinding

class UserAdapter : BaseAdapter<User, ItemUserBinding>(ItemUserBinding::inflate) {

    override fun bindData(binding: ItemUserBinding, item: User, position: Int) {
        binding.tvName.text = item.name
        binding.tvAge.text = item.age.toString()
    }

    override fun onItemClick(binding: ItemUserBinding, item: User, position: Int) {
    }
}