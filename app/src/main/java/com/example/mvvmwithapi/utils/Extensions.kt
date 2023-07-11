package com.example.mvvmwithapi.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.mvvmwithapi.R

fun ImageView.loadURL(url:String?){
    url?.let{
        Glide
            .with(this)
            .load(url)
            .centerCrop()
            .placeholder(R.drawable.ic_android_black_24dp)
            .into(this);

    }
}