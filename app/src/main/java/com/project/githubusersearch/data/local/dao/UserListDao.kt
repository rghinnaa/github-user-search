package com.project.githubusersearch.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.githubusersearch.data.local.entity.User

@Dao
interface UserListDao {

    @Query("SELECT * FROM USER_ENTITY ORDER BY id")
    fun getUserPaging(): PagingSource<Int, User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<User>)

    @Query("DELETE FROM USER_ENTITY")
    suspend fun clearAllUsers()

}