package com.project.githubusersearch.data.remote.source.data.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.project.githubusersearch.data.local.GithubUserDatabase
import com.project.githubusersearch.data.local.entity.User
import com.project.githubusersearch.data.remote.api.ApiCallback
import com.project.githubusersearch.data.remote.model.SearchUserResponse
import com.project.githubusersearch.util.Const
import retrofit2.HttpException
import java.io.IOException

@ExperimentalPagingApi
class UserListMediator(
    private val apiCallback: ApiCallback,
    private val database: GithubUserDatabase,
    private val token: String
) : RemoteMediator<Int, User>() {

    var data: List<SearchUserResponse.Item> = emptyList()
    private val userDao = database.userListDao()
    private var lastId = 0

    override suspend fun load(loadType: LoadType, state: PagingState<Int, User>): MediatorResult {
        try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    lastItem?.id ?: lastId
                }
            }

            val response = apiCallback.userList(
                token,
                loadKey,
                Const.Paging.PER_PAGE_SMALL
            )

            data = response.body().orEmpty()

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    userDao.clearAllUsers()
                }

                val users = data.map { item ->
                    User(
                        id = item.id,
                        username = item.login,
                        avatar = item.avatarUrl
                    )
                }
                userDao.insertUsers(users)
            }

            return MediatorResult.Success(endOfPaginationReached = data.isEmpty())
        } catch (e: IOException) {
            return MediatorResult.Error(e)
        } catch (e: HttpException) {
            return MediatorResult.Error(e)
        }
    }
}