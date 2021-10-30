package com.example.footballapp.ui.webSearch

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentWebSearchBinding
import com.example.footballapp.ui.base.BaseFragment

class WebSearchFragment: BaseFragment<FragmentWebSearchBinding>(){
    override val viewModel: WebSearchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWebSearchBinding
        get() = FragmentWebSearchBinding::inflate



    @SuppressLint("SetJavaScriptEnabled")
    override fun setup() {

        openWebViewToSearchInFragment()

    }

    private fun openWebViewToSearchInFragment() {
        binding?.webSearch?.webViewClient = WebViewClient()
        binding?.webSearch?.apply {
            loadUrl("https://www.google.com/")
            settings.safeBrowsingEnabled = true
            settings.javaScriptEnabled = true
        }
    }

}