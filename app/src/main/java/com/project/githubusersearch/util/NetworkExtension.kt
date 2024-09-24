package com.project.githubusersearch.util

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.project.githubusersearch.base.BaseResponse
import com.project.githubusersearch.data.remote.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

private fun Throwable.handleException() = when (this) {
    is IOException -> "Failed to read response!"
    is SocketTimeoutException -> "Timeout!"
    is UnknownHostException -> "Check your internet connection!"
    else -> "An error occurred!"
}

fun Int.handleCode() = when (this) {
    401 -> "API KEY tidak sesuai"
    403 -> "Silahkan masukkan API KEY"
    404 -> "Halaman yang dituju tidak dapat ditemukan, harap mencoba ulang secara berkala"
    422 -> "Data yang diinputkan tidak dapat diproses, harap coba input data yang berbeda atau tunggu beberapa saat"
    else -> "Mohon maaf terjadi kesalahan, tunggu beberapa saat untuk mencoba kembali"
}

val Throwable.parsedMessage get() = handleException()

inline fun<reified T: Any?> ResponseBody.parse(): T? {
    val classType= object: TypeToken<T>(){}.type
    return Gson().fromJson(charStream(), classType)
}

inline fun <reified T> flowResponse(
    handleError: Boolean = true,
    crossinline errorMessage: (String) -> String = { "" },
    crossinline responseBody: suspend () -> Response<T>
) = flow<Result<T>> {
    val response = responseBody.invoke()
    val body = response.body()

    if (response.isSuccessful) {
        emit(Result.success(body))
    } else {
        Log.e("resultError", "error: $response")
        val isError = response.code() in 400..599
        val errorBody = response.errorBody()?.parse<BaseResponse<T>>()

        val message =
            if (isError && handleError) response.code().handleCode()
            else if (errorMessage.invoke(errorBody.toString()) != "") errorMessage.invoke(errorBody.toString())
            else errorBody.toString()

        emit(
            Result.error(message, errorBody?.results)
        )
    }
}.onStart { emit(Result.loading()) }
    .flowOn(Dispatchers.IO)
    .retryWhen { cause, attempt ->
        attempt <= 3 && cause is SocketTimeoutException
    }
    .catch { throwable ->
        emit(Result.error<T>(throwable.parsedMessage, null))
    }

fun generateAESKey(keySize: Int = 256): SecretKey {
    val keyGenerator = KeyGenerator.getInstance("AES")
    keyGenerator.init(keySize)
    return keyGenerator.generateKey()
}

fun aesDecrypt(encryptedData: ByteArray, secretKey: SecretKey): ByteArray {
    val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
    val ivParameterSpec = IvParameterSpec(ByteArray(16)) // Use the same IV as used in encryption
    cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec)
    return cipher.doFinal(encryptedData)
}
