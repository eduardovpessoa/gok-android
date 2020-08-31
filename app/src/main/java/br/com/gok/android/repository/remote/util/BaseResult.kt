package br.com.gok.android.repository.remote.util

import com.google.gson.GsonBuilder
import java.io.IOException
import retrofit2.Response

sealed class BaseResult<out T> {

    data class Success<out T>(val successData: T) : BaseResult<T>()
    class Error(
        private val exception: java.lang.Exception,
        private val message: String? = exception.localizedMessage
    ) : BaseResult<Nothing>()
}

fun <T : Any> handleApiError(resp: Response<T>): BaseResult.Error {
    val error = ApiErrorUtils.parseError(resp)
    return BaseResult.Error(Exception(error))
}

fun <T : Any> handleSuccess(response: Response<T>): BaseResult<T> {
    response.body()?.let {
        return BaseResult.Success(it)
    } ?: return handleApiError(response)
}

object ApiErrorUtils {
    fun parseError(response: Response<*>): String {
        val gson = GsonBuilder().create()
        val error: String
        try {
            error = gson.fromJson(response.errorBody()?.string(), String::class.java)
        } catch (e: IOException) {
            return "Unknown error"
        }
        return error
    }
}