package br.com.gok.android.repository

import android.content.Context
import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.model.dto.ProductsDTO
import br.com.gok.android.repository.remote.util.NetworkManager.isOnline
import br.com.gok.android.repository.remote.util.NetworkUtils.handleApiError
import br.com.gok.android.repository.remote.util.NetworkUtils.handleSuccess

class DigioRepositoryImpl(private val api: DigioAPI, private val context: Context) :
    DigioRepository {
    override fun fetchProducts(): BaseResult<ProductsDTO> {
        return try {
            val response = api.fetchProducts()
            if (response.isSuccessful) {
                handleSuccess(response)
            } else {
                handleApiError(response)
            }
        } catch (e: Exception) {
            BaseResult.Error(e)
        }
    }
}