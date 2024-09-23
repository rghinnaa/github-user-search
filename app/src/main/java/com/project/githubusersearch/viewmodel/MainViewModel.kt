package com.project.githubusersearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.project.githubusersearch.data.remote.repository.MainRepository
import com.project.githubusersearch.util.Const
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    mainRepository: MainRepository
) : ViewModel() {
    private val repository = mainRepository

    fun requestSearchUserPaging(key: String) = repository.requestUserSearch(Const.APP_TOKEN, key).asLiveData()

}