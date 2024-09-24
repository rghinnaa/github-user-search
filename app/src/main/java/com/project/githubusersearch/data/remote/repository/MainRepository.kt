package com.project.githubusersearch.data.remote.repository

import androidx.paging.PagingData
import com.project.githubusersearch.data.remote.model.PublicRepositoryUserResponse
import com.project.githubusersearch.data.remote.source.callback.MainSourceCallback
import com.project.githubusersearch.data.remote.source.data.MainDataSource
import kotlinx.coroutines.flow.Flow

class MainRepository(
    mainRemoteDataSource: MainDataSource
) : MainSourceCallback {
    private val remoteDataSource = mainRemoteDataSource

    override fun requestUserList(token: String) = remoteDataSource.requestUserPaging(token)

    override fun requestUserSearch(
        token: String,
        key: String
    ) = remoteDataSource.requestSearchUserPaging(token, key)

    override fun requestUserDetail(
        token: String,
        username: String
    ) = remoteDataSource.requestDetailUser(token, username)

    override fun requestUserRepository(
        token: String,
        username: String
    ) = remoteDataSource.requestRepositoryUserPaging(token, username)
}