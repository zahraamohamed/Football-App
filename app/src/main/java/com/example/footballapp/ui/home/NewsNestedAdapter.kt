package com.example.footballapp.ui.home

import com.example.footballapp.R
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.news.INewsListener

class NewsNestedAdapter(
    items: List<Article>,
    listener: HomeInteractionListener
) : BaseAdapter<Article>(items, listener) {

    override val layoutId: Int = R.layout.item_news
}