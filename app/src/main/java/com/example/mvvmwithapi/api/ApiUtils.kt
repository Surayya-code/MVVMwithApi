package com.example.mvvmwithapi.api

class ApiUtils {
    companion object{
        fun getApi():ProjectApi{
            return RetrofitClient.getRetrofitClient().create(ProjectApi::class.java)
        }
    }
}