package com.example.androidmvvmprojectbase.ui.home

import com.example.androidmvvmprojectbase.base.BaseAdapter
import com.example.androidmvvmprojectbase.data.Dog
import com.example.androidmvvmprojectbase.databinding.ItemDogBinding

class DogAdapter : BaseAdapter<Dog, ItemDogBinding>(ItemDogBinding::inflate) {
    override fun bindData(binding: ItemDogBinding, item: Dog, position: Int) {
        binding.tvName.text = "Tên: ${item.name}"
        binding.tvDescription.text = "Mô tả: ${item.description}"
        binding.tvMinLife.text = "Tuổi tối thiểu: ${item.minLife}"
        binding.tvMaxLife.text = "Tuổi tối đa: ${item.maxLife}"
    }

    override fun onItemClick(binding: ItemDogBinding, item: Dog, position: Int) {

    }
}