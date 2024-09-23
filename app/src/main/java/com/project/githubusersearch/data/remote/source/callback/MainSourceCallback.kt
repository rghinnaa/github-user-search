package com.project.githubusersearch.data.remote.source.callback

import androidx.paging.PagingData
import com.project.githubusersearch.data.remote.model.SearchUserResponse
import kotlinx.coroutines.flow.Flow

interface MainSourceCallback {

    fun requestUserSearch(token: String, key: String): Flow<PagingData<SearchUserResponse.Item>>

}