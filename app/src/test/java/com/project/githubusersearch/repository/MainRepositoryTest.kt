package com.project.githubusersearch.repository

import com.project.githubusersearch.data.local.GithubUserDatabase
import com.project.githubusersearch.data.remote.Result
import com.project.githubusersearch.data.remote.api.ApiCallback
import com.project.githubusersearch.data.remote.model.DetailUserResponse
import com.project.githubusersearch.data.remote.repository.MainRepository
import com.project.githubusersearch.data.remote.source.data.MainDataSource
import com.project.githubusersearch.util.Const
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import retrofit2.Response

class MainRepositoryTest {

    @Mock
    private lateinit var apiCallback: ApiCallback
    @Mock
    private lateinit var githubUserDatabase: GithubUserDatabase

    private lateinit var mainDataSource: MainDataSource
    private lateinit var mainRepository: MainRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        mainDataSource = MainDataSource(apiCallback, githubUserDatabase)
        mainRepository = MainRepository(mainDataSource)
    }

    @Test
    fun `test getUser returns correct user`() = runTest {
        val username = "rghinnaa"
        val mockResponse = DetailUserResponse(login = username)

        `when`(apiCallback.userDetail(Const.APP_TOKEN, username)).thenReturn(Response.success(mockResponse))

        var usernameResult = ""
        mainRepository.requestUserDetail(Const.APP_TOKEN, username).collect {
            if(it is Result.Success) {
                usernameResult = it.results?.login.toString()
            }
        }

        assertEquals(username, usernameResult)
    }

}