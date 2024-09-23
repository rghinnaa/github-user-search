package com.project.githubusersearch.base

data class BaseResponse<T>(
    var results: T? = null,
    var status: Any? = null,
    var message: Any? = null
)