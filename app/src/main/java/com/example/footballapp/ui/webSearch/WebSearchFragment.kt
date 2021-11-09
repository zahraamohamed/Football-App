package com.example.footballapp.ui.webSearch

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.footballapp.databinding.FragmentWebSearchBinding
import com.example.footballapp.ui.base.BaseFragment

class WebSearchFragment: BaseFragment<FragmentWebSearchBinding>() {
    private val args : WebSearchFragmentArgs by navArgs()
    override val viewModel: WebSearchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWebSearchBinding
        get() = FragmentWebSearchBinding::inflate


    @SuppressLint("SetJavaScriptEnabled")
    override fun setup(
    ) {
        initWebSearchView()

    }

    private fun initWebSearchView() {

        val article = args.article.url
        binding.webSearch.apply {
                 binding.webSearch.apply {
                     webViewClient = WebViewClient()
                     if (article != null) {
                         loadUrl(article)
                     }
                 }
             }
         }
    }



