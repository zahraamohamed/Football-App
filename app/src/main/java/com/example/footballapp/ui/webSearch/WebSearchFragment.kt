package com.example.footballapp.ui.webSearch

import android.annotation.SuppressLint
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentWebSearchBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.player.PlayerDetailsFragmentArgs
import com.example.footballapp.ui.teams.TeamDetailsFragment

class WebSearchFragment: BaseFragment<FragmentWebSearchBinding>() {
    override val viewModel: WebSearchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentWebSearchBinding
        get() = FragmentWebSearchBinding::inflate

    private val argsPlayer: PlayerDetailsFragmentArgs by navArgs()
    //private val argsTeam: TeamDetailsFragmentArgs by navArgs()

    @SuppressLint("SetJavaScriptEnabled")
    override fun setup(
    ) {
        openWebViewToSearchInFragment()

    }

    private fun openWebViewToSearchInFragment() {

        val searchName = argsPlayer.playerId
        var WEB_SEARCH_URL = "https://www.google.com/search"
        val search_url = "$WEB_SEARCH_URL?q=$searchName"
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


       // val searchName: Int
       // if (searchName = argsPlayer.playerId) {
       //     webView(searchName)
       //  } else
       // if(searchName = argsTeam.playerId){
       //  webView(searchName)
       // }

   // private fun webView(searchName:Int) {
    //        var WEB_SEARCH_URL = "https://www.google.com/search"
    //        val search_url = "$WEB_SEARCH_URL?q=$searchName"
    //        binding.webSearch?.apply {
    //            webViewClient = WebViewClient()
    //            loadUrl(search_url)
    //            settings.apply {
    //                safeBrowsingEnabled = true
    //                javaScriptEnabled = true
    //            }
    //
    //        }
    //    }




