package com.aniket.e_commerceapp.data.api

import com.aniket.e_commerceapp.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("rest/V1/productdetails/6701/253620")
    suspend fun getProduct(
        @Query("lang") lang: String = "en",
        @Query("store") store: String = "KWD"
    ): ProductResponse
}