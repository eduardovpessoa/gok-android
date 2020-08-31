package br.com.gok.android.repository.remote.api

import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.model.dto.ProductsDTO

class DigioRepositoryImpl(private val api: DigioServiceAPI) : DigioRepository {
    override suspend fun fetchProducts(): BaseResult<ProductsDTO> =
        api.getServiceAPI().fetchProducts()
}