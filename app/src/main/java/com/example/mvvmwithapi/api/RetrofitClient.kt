package com.example.mvvmwithapi.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object{
        fun getRetrofitClient():Retrofit{
            return Retrofit.Builder().baseUrl("https://api.escuelajs.co/api/v1/").addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}