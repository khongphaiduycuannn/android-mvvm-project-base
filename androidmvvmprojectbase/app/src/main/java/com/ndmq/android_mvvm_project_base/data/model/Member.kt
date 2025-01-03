package com.ndmq.android_mvvm_project_base.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Member(
    val name: String,
    val imageUrl: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
