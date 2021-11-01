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
    override val viewModel: WebSearchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWebSearchBinding
        get() = FragmentWebSearchBinding::inflate

    private val argsPlayer: WebSearchFragmentArgs by navArgs()



    @SuppressLint("SetJavaScriptEnabled")
    override fun setup(
    ) {
        openWebViewToSearchInFragment()

    }

    private fun openWebViewToSearchInFragment() {
        var WEB_SEARCH_URL = "https://www.google.com/search"
        val search_url = "$WEB_SEARCH_URL?q=${argsPlayer.playerId}"
        binding.webSearch?.apply {
            webViewClient = WebViewClient()
            loadUrl(search_url)
            settings.apply {
                safeBrowsingEnabled = true
                javaScriptEnabled = true
            }

        }
    }
}



