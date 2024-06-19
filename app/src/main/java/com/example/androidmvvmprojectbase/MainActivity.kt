package com.example.androidmvvmprojectbase

import android.app.Dialog
import android.widget.Toast
import com.example.androidmvvmprojectbase.base.BaseActivity
import com.example.androidmvvmprojectbase.base.DataState
import com.example.androidmvvmprojectbase.databinding.ActivityMainBinding
import com.example.androidmvvmprojectbase.utils.extension.checkHasPermission
import com.example.androidmvvmprojectbase.utils.extension.requestPermission

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val dialog by lazy { Dialog(this) }

    override fun initData() {

    }

    override fun bindData() {
        if (!checkHasPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE)){
            requestPermission(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE))
        }
    }

    override fun setOnClick() {
//        binding.btnShowToast.setOnClickListener {
//            val text = binding.edtNumber.text.toString()
//
//            var result: DataState<Int>? = null
//            try {
//                result = DataState.Success(text.toInt())
//            } catch (e: Exception) {
//                result = DataState.Error(e)
//            }
//
//            when(result) {
//                is DataState.Success -> {
//                    Toast.makeText(this, "${result.data}", Toast.LENGTH_SHORT).show()
//                }
//
//                is DataState.Error -> {
//                    Toast.makeText(this, "${result.exception.message}", Toast.LENGTH_SHORT).show()
//                }
//                null -> {}
//            }
//        }
    }
}