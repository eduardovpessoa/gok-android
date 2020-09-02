package br.com.gok.android.repository

import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.model.dto.ProductsDTO

interface DigioRepository {
    fun fetchProducts(): BaseResult<ProductsDTO>
}