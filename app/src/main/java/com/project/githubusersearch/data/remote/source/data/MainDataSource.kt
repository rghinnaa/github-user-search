package com.project.githubusersearch.data.remote.source.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.project.githubusersearch.data.remote.api.ApiCallback
import com.project.githubusersearch.data.remote.source.data.paging.SearchUserPagingSource
import com.project.githubusersearch.util.Const
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class MainDataSource(callback: ApiCallback) {
    private val apiCallback = callback

    fun requestSearchUserPaging(
        token: String,
        key: String
    ) = Pager(
        config = PagingConfig(Const.Paging.PER_PAGE_SMALL)
    ) {
        SearchUserPagingSource(
            apiCallback,
            token,
            key
        )
    }.flow
        .flowOn(Dispatchers.IO)
        .catch { throwable ->
            Log.e("error", throwable.toString())
        }

}