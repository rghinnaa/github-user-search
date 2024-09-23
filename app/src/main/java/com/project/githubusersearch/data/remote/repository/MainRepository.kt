package com.project.githubusersearch.data.remote.repository

import com.project.githubusersearch.data.remote.source.callback.MainSourceCallback
import com.project.githubusersearch.data.remote.source.data.MainDataSource

class MainRepository(
    mainRemoteDataSource: MainDataSource,
) : MainSourceCallback {
    private val remoteDataSource = mainRemoteDataSource

    override fun requestUserSearch(
        token: String,
        key: String
    ) = remoteDataSource.requestSearchUserPaging(token, key)
}