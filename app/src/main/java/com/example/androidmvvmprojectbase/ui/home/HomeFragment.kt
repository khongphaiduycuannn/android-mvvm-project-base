package com.example.androidmvvmprojectbase.ui.home

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidmvvmprojectbase.base.BaseFragment
import com.example.androidmvvmprojectbase.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override val viewModel: HomeViewModel
        get() = ViewModelProvider(this)[HomeViewModel::class.java]

    private val dogAdapter = DogAdapter()

    override fun initData() {
        viewModel.refreshData()
    }

    override fun bindData() {
        binding.rclDogList.adapter = dogAdapter
        binding.rclDogList.layoutManager = LinearLayoutManager(context)
    }

    override fun observeData() {
        viewModel.dogList.observe(viewLifecycleOwner) {
            dogAdapter.setDataList(it.toMutableList())
        }
    }

    override fun setOnClick() {

    }
}