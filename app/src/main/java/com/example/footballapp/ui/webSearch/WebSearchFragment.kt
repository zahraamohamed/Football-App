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

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun setup() {

        binding.apply {
            lifecycleOwner = this@WebSearchFragment
            viewModel = viewModel
            webView = searchWebView
            searchWebView.settings.javaScriptEnabled = true
        }

    }
}