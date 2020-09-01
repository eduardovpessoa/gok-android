package br.com.gok.android.repository.remote.util

import retrofit2.Response

object NetworkUtils {
    fun <T : Any> handleApiError(resp: Response<T>): BaseResult.Error {
        val error = ApiErrorUtils.parseError(resp)
        return BaseResult.Error(Exception(error.message))
    }

    fun <T : Any> handleSuccess(response: Response<T>): BaseResult<T> {
        response.body()?.let {
            return BaseResult.Success(it)
        } ?: return handleApiError(response)
    }
}