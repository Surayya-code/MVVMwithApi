package com.example.mvvmwithapi.ui.home

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithapi.api.ApiUtils
import com.example.mvvmwithapi.model.ProductResponseModelItem
import kotlinx.coroutines.launch

class HomeMVVM:ViewModel() {
    private val api=ApiUtils.getApi()
    val data= MutableLiveData<List<ProductResponseModelItem>>()
    val loading=MutableLiveData<Boolean>()
    val error=MutableLiveData<String>()

    init{
        getProductApi()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun getProductApi(){
        viewModelScope.launch {
        loading.value=true
        try {
          val response=api.getAllProducts()
            if(response.isSuccessful){
                response.body()?.let {
                    data.value=it
                }
            }
            loading.value=false
        }catch (e:Exception){
          loading.value=false
            error.value=e.localizedMessage?:"Error Bad Format"
        }
        }
    }
}