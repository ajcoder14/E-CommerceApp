package com.aniket.e_commerceapp.data.repository

import com.aniket.e_commerceapp.data.api.RetrofitClient

class ProductRepository{

    suspend fun getProduct() =
        RetrofitClient.api.getProduct()
}