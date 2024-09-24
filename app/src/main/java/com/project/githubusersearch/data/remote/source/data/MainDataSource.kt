package com.project.githubusersearch.data.remote.source.data

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.project.githubusersearch.data.local.GithubUserDatabase
import com.project.githubusersearch.data.remote.api.ApiCallback
import com.project.githubusersearch.data.remote.source.data.mediator.UserListMediator
import com.project.githubusersearch.data.remote.source.data.paging.RepositoryUserPagingSource
import com.project.githubusersearch.data.remote.source.data.paging.SearchUserPagingSource
import com.project.githubusersearch.util.Const
import com.project.githubusersearch.util.flowResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn

class MainDataSource(callback: ApiCallback, githubUserDatabase: GithubUserDatabase) {
    private val apiCallback = callback
    private val db = githubUserDatabase
    private val dao = githubUserDatabase.userListDao()

    @OptIn(ExperimentalPagingApi::class)
    fun requestUserPaging(
        token: String
    ) = Pager(
        config = PagingConfig(Const.Paging.PER_PAGE_SMALL),
        remoteMediator = UserListMediator(apiCallback, db, token),
        pagingSourceFactory = { dao.getUserPaging() }
    ).flow

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

    fun requestDetailUser(token: String, username: String) = flowResponse {
        apiCallback.userDetail(token, username)
    }

    fun requestRepositoryUserPaging(
        token: String,
        username: String
    ) = Pager(
        config = PagingConfig(Const.Paging.PER_PAGE_SMALL)
    ) {
        RepositoryUserPagingSource(
            apiCallback,
            token,
            username
        )
    }.flow
        .flowOn(Dispatchers.IO)
        .catch { throwable ->
            Log.e("error", throwable.toString())
        }

}