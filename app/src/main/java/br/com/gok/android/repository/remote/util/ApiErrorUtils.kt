package br.com.gok.android.repository.remote.util

import com.google.gson.GsonBuilder
import retrofit2.Response
import java.io.IOException

object ApiErrorUtils {

    fun parseError(response: Response<*>): APIError {

        val gson = GsonBuilder().create()
        val error: APIError

        try {
            error = gson.fromJson(response.errorBody()?.string(), APIError::class.java)
        } catch (e: IOException) {
            return APIError()
        }
        return error
    }
}