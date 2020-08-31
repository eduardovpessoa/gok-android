package br.com.gok.android.repository.remote.api

import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.model.dto.ProductsDTO

interface DigioRepository {
    suspend fun fetchProducts(): BaseResult<ProductsDTO>
}