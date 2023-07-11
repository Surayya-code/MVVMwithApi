package com.example.mvvmwithapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithapi.databinding.ItemProductBinding
import com.example.mvvmwithapi.model.ProductResponseModelItem
import java.security.ProtectionDomain

class ProductAdapter :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    val productList= arrayListOf<ProductResponseModelItem>()

    inner class ProductViewHolder(private val  itemProductBinding: ItemProductBinding):RecyclerView.ViewHolder(itemProductBinding.root){
       fun bind(productResponseModelItem: ProductResponseModelItem){
           itemProductBinding.product=productResponseModelItem
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layout=ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProductViewHolder(layout)
    }

    override fun getItemCount(): Int {
     return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }
   fun updateList(list:List<ProductResponseModelItem>){
       productList.clear()
       productList.addAll(list)
       notifyDataSetChanged()
   }
}