package br.com.gok.android.repository.remote.api

import br.com.gok.android.repository.remote.model.dto.ProductsDTO
import br.com.gok.android.repository.remote.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface DigioAPI {
    @GET(Constants.PRODUCTS)
    suspend fun fetchProducts(): Response<ProductsDTO>
}