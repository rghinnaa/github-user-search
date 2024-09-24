package com.project.githubusersearch.data.remote.source.data.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.project.githubusersearch.data.remote.api.ApiCallback
import com.project.githubusersearch.data.remote.model.PublicRepositoryUserResponse
import com.project.githubusersearch.util.Const

class RepositoryUserPagingSource(
    private val apiCallback: ApiCallback,
    private val token: String,
    private val username: String
) : PagingSource<Int, PublicRepositoryUserResponse>() {

    var data: List<PublicRepositoryUserResponse> = emptyList()

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int,  PublicRepositoryUserResponse> {
        return try {
            val nextPage = params.key ?: 1

            val response = apiCallback.userPublicRepository(
                token,
                username,
                nextPage,
                Const.Paging.PER_PAGE_SMALL
            )

            data = response.body().orEmpty()

            LoadResult.Page(
                data,
                if (nextPage == 0) null else nextPage - 1,
                if (data.isEmpty()) null else nextPage + 1
            )
        } catch (e: Exception) {
            Log.e("paging error", e.message.orEmpty())
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PublicRepositoryUserResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }
}