package br.com.gok.android.repository

import br.com.gok.android.repository.remote.model.dto.ProductsDTO
import br.com.gok.android.repository.remote.util.Constants
import retrofit2.Response
import retrofit2.http.GET

interface DigioAPI {
    @GET(Constants.PRODUCTS)
    fun fetchProducts(): Response<ProductsDTO>
}