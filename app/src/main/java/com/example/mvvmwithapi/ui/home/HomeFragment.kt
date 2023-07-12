package com.example.mvvmwithapi.ui.home

import android.view.View
import androidx.fragment.app.viewModels
import com.example.mvvmwithapi.adapter.ProductAdapter
import com.example.mvvmwithapi.base.BaseFragment
import com.example.mvvmwithapi.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<HomeMVVM,FragmentHomeBinding>(
    FragmentHomeBinding::inflate
){
    override val viewModel: HomeMVVM by viewModels<HomeMVVM>()
    private val productAdapter=ProductAdapter()
    override fun createFinished() {
    // viewModel.getProductApi()
        binding.rvProduct.adapter=productAdapter
    }

    override fun observeEvents() {
    viewModel.data.observe(viewLifecycleOwner){
        //Log.e("gelenData",it.toString())
        productAdapter.differ.submitList(it)
    }
        viewModel.loading.observe(viewLifecycleOwner){
            if(it){
                binding.progressBar2.visibility= View.VISIBLE
            }else{
                binding.progressBar2.visibility= View.GONE
            }
        }
    }

}