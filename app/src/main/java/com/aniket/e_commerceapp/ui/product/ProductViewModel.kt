package com.aniket.e_commerceapp.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aniket.e_commerceapp.data.model.ProductResponse
import com.aniket.e_commerceapp.data.repository.ProductRepository
import kotlinx.coroutines.launch


class ProductViewModel(
    private val repository: ProductRepository
) : ViewModel() {

    private val _product = MutableLiveData<ProductResponse>()
    val product: LiveData<ProductResponse> = _product

    fun loadProduct() {

        viewModelScope.launch {

            try {
                _product.value = repository.getProduct()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}