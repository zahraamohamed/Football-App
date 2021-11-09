package com.example.footballapp.ui.news


import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import com.example.footballapp.databinding.FragmentNewsBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.home.HomeFragmentDirections


class NewsFragment :BaseFragment<FragmentNewsBinding>() {
    override val viewModel: NewsViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsBinding
        get() = FragmentNewsBinding::inflate

    override fun setup() {
        binding.recyclerNews.adapter =NewsAdapter(mutableListOf(), viewModel)
       /* arguments?.getSerializable("article").let {
                viewModel.onNewsClick(it)
        }*/

        viewModel.navigateToWebView.observe( this,{ event ->
            event.getContentIfNotHandled()?.let {
                val action = HomeFragmentDirections.actionHomeFragmentToWebSearchFragment(it)
                findNavController().navigate(action)
                Log.v("article", it.url.toString())

            }
        }
        )

    }

}