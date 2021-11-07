package com.example.footballapp.ui.news

import android.widget.BaseAdapter
import com.example.footballapp.R
import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.model.domain.teamDetailsResponse.Squad

class NewsAdapter(val items:List<Article>,
                  val listener : INewsListener
) : com.example.footballapp.ui.base.BaseAdapter<Article>(items, listener) {
    override val layoutId: Int = R.layout.item_news
}