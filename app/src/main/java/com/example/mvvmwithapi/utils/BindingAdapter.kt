package com.example.mvvmwithapi.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("load_URL")
fun loadImage(imageView: ImageView,url:String){
  imageView.loadURL(url)
}