package com.example.mvvmwithapi.api

import com.example.mvvmwithapi.model.ProductResponseModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ProjectApi {
    @GET("products")
   suspend fun getAllProducts():Response<List<ProductResponseModelItem>>

}