package com.project.githubusersearch.data.remote

sealed class Result<T> {
    class Nothing<T> : Result<T>() {
        override fun toString() = "Result.Nothing"
    }

    class Loading<T> : Result<T>() {
        override fun toString() = "Result.Loading"
    }

    class Success<T>(val results: T?) : Result<T>() {
        override fun toString() = "Result.Success with item : [$results]"
    }

    class Error<T>(
        val message: String,
        val data: T?
    ) : Result<T>() {
        override fun toString() = "Result.Error with Item Of [results: $data], [Message: $message]"
    }

    companion object {
        fun <T> nothing() = Nothing<T>()
        fun <T> loading() = Loading<T>()
        fun <T> success(data: T?) = Success(data)
        fun <T> error(message: String, data: T?) = Error<T>(message, data)
    }
}