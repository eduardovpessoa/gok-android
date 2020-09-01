package br.com.gok.android.repository.remote.api

import android.content.Context
import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.model.dto.ProductsDTO
import br.com.gok.android.repository.remote.util.NetworkManager.isOnline
import br.com.gok.android.repository.remote.util.NetworkUtils.handleApiError
import br.com.gok.android.repository.remote.util.NetworkUtils.handleSuccess

class DigioRepositoryImpl(private val api: DigioAPI, private val context: Context) :
    DigioRepository {
    override suspend fun fetchProducts(): BaseResult<ProductsDTO> {
        return if (isOnline(context)) {
            try {
                val response = api.fetchProducts()
                if (response.isSuccessful) {
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                BaseResult.Error(e)
            }
        } else {
            BaseResult.Error(Exception("No Network Connectivity!"))
        }
    }
}