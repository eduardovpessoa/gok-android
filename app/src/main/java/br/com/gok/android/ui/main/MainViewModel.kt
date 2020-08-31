package br.com.gok.android.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gok.android.repository.remote.api.DigioRepositoryImpl
import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.model.dto.ProductsDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DigioRepositoryImpl) : ViewModel() {

    val products = MutableLiveData<ProductsDTO>()

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.fetchProducts()) {
                is BaseResult.Success -> {
                    products.value = result.successData
                }
                is BaseResult.Error -> {

                }
            }
        }
    }
}