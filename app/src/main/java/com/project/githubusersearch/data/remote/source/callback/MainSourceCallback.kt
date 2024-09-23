package com.project.githubusersearch.data.remote.source.callback

import androidx.paging.PagingData
import com.project.githubusersearch.data.remote.Result
import com.project.githubusersearch.data.remote.model.DetailUserResponse
import com.project.githubusersearch.data.remote.model.SearchUserResponse
import kotlinx.coroutines.flow.Flow

interface MainSourceCallback {

    fun requestUserList(token: String): Flow<PagingData<SearchUserResponse.Item>>

    fun requestUserSearch(token: String, key: String): Flow<PagingData<SearchUserResponse.Item>>

    fun requestUserDetail(token: String, username: String): Flow<Result<DetailUserResponse>>

}