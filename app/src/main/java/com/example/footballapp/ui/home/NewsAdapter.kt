package com.example.footballapp.ui.home

import com.example.footballapp.R
import com.example.footballapp.model.domain.footballNewsResponse.Article

class NewsAdapter(val items:List<Article>,
                  val listener : HomeInteractionListener
) : com.example.footballapp.ui.base.BaseAdapter<Article>(items, listener) {
    override val layoutId: Int = R.layout.item_news
}