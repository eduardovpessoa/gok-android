package br.com.gok.android.ui.main

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gok.android.repository.remote.api.DigioRepositoryImpl
import br.com.gok.android.repository.remote.util.BaseResult
import br.com.gok.android.repository.remote.model.dto.ProductsDTO
import br.com.gok.android.repository.remote.util.SingleLiveEvent
import kotlinx.coroutines.launch

class MainViewModel(private val repository: DigioRepositoryImpl) : ViewModel() {

    val showLoading = ObservableBoolean()
    val products = MutableLiveData<ProductsDTO>()
    val showError = SingleLiveEvent<String>()

    fun getProducts() {
        showLoading.set(true)
        viewModelScope.launch {
            when (val result = repository.fetchProducts()) {
                is BaseResult.Success -> {
                    products.value = result.successData
                    showError.value = null
                }
                is BaseResult.Error -> {
                    showError.value = result.exception.message
                }
            }
            showLoading.set(false)
        }
    }
}