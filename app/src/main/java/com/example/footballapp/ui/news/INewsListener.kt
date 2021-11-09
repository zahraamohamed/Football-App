package com.example.footballapp.ui.news

import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.ui.base.BaseInteractionListener
import com.example.footballapp.ui.home.HomeInteractionListener

interface INewsListener: BaseInteractionListener {
    fun onNewsClick( articleDetails:Article)
}