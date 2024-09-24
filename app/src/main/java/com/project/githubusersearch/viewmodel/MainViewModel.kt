package com.project.githubusersearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.project.githubusersearch.BuildConfig
import com.project.githubusersearch.data.remote.Result
import com.project.githubusersearch.data.remote.model.DetailUserResponse
import com.project.githubusersearch.data.remote.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
) : ViewModel() {
    private val repository = mainRepository

    private var _userDetail: MutableLiveData<Result<DetailUserResponse>> = MutableLiveData()
    val userDetail: LiveData<Result<DetailUserResponse>> get() = _userDetail

    fun requestUserListPaging() = repository
            .requestUserList(BuildConfig.AUTH_KEY)
            .asLiveData(viewModelScope.coroutineContext)

    fun requestSearchUserPaging(key: String) = repository
        .requestUserSearch(BuildConfig.AUTH_KEY, key)
        .asLiveData()

    fun requestDetailUser(username: String) = repository.requestUserDetail(BuildConfig.AUTH_KEY, username)
        .onEach { result ->
            _userDetail.value = result
        }.launchIn(viewModelScope)

    fun requestRepositoryUserPaging(username: String) = repository
        .requestUserRepository(BuildConfig.AUTH_KEY, username)
        .asLiveData()

}