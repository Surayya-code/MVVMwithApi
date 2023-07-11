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
            .placeholder(R.drawable.baseline_download_for_offline_24)
            .into(this);

    }
}