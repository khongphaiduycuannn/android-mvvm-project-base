package com.ndmq.android_mvvm_project_base.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.ndmq.android_mvvm_project_base.base.BaseActivity
import com.ndmq.android_mvvm_project_base.data.model.Member
import com.ndmq.android_mvvm_project_base.databinding.ActivityMainBinding
import com.ndmq.android_mvvm_project_base.itemMember
import com.ndmq.android_mvvm_project_base.utils.extension.logd
import com.ndmq.android_mvvm_project_base.utils.extension.loge
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    ActivityMainBinding::inflate
) {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeData()
    }

    override fun onResume() {
        super.onResume()
        initData()
    }

    private fun initData() {
        viewModel.pullRemoteData()
    }

    private fun observeData() {
        viewModel.allMembers.observe(this) {
            logd(it.toString())
            loadMemberEpoxy(it)
        }

        viewModel.error.observe(this) {
            loge(it.message.toString())
        }
    }


    private fun loadMemberEpoxy(data: List<Member>) {
        binding.rclMembers.withModels {
            data.forEach { member ->
                itemMember {
                    id(member.id)
                    name(member.name)
                    imageUrl(member.imageUrl)
                }
            }
        }
    }
}