package br.com.gok.android.repository.remote.util

sealed class BaseResult<out T> {

    data class Success<out T>(val successData: T) : BaseResult<T>()
    class Error(
        val exception: java.lang.Exception,
        val message: String = exception.localizedMessage.orEmpty()
    ) : BaseResult<Nothing>()
}