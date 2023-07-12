package com.example.mvvmwithapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithapi.databinding.ItemProductBinding
import com.example.mvvmwithapi.model.ProductResponseModelItem

class ProductAdapter :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

    //val productList= arrayListOf<ProductResponseModelItem>()

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
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    //   fun updateList(list:List<ProductResponseModelItem>){
//       productList.clear()
//       productList.addAll(list)
//       notifyDataSetChanged()
//   }
    val differ = AsyncListDiffer(this, diffUtilProduct)

    object diffUtilProduct : DiffUtil.ItemCallback<ProductResponseModelItem>() {
        override fun areItemsTheSame(
            oldItem: ProductResponseModelItem,
            newItem: ProductResponseModelItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProductResponseModelItem,
            newItem: ProductResponseModelItem
        ): Boolean {
            return oldItem == newItem
        }

    }
}