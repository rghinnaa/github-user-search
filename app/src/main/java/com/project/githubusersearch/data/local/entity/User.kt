package com.project.githubusersearch.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.project.githubusersearch.util.Const.Entity.USER

@Entity(tableName = USER, indices = [Index(value = ["username"], unique = true)])
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val avatar: String? = null,
    val username: String? = null
)