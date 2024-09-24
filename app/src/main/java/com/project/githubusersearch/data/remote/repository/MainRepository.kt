package com.project.githubusersearch.data.remote.repository

import com.project.githubusersearch.data.remote.source.callback.MainSourceCallback
import com.project.githubusersearch.data.remote.source.data.MainDataSource

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

}