package com.project.githubusersearch.data.remote.api

import com.project.githubusersearch.data.remote.model.SearchUserResponse
import com.project.githubusersearch.util.Const
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiCallback {

    @GET(Const.Network.SEARCH_USER)
    suspend fun userSearch(
        @Header("Authorization") token: String,
        @Query("q") key: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Response<SearchUserResponse>

}