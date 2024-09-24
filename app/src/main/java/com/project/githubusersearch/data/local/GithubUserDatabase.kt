package com.project.githubusersearch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.githubusersearch.data.local.dao.UserListDao
import com.project.githubusersearch.data.local.entity.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class GithubUserDatabase : RoomDatabase() {
    abstract fun userListDao(): UserListDao

}