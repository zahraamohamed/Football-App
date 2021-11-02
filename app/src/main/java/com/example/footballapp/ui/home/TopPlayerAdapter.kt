package com.example.footballapp.ui.home

import com.example.footballapp.R
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.ui.base.BaseAdapter

class TopPlayerAdapter(
    items: List<Scorer>,
    listener: HomeInteractionListener
) : BaseAdapter<Scorer>(items, listener) {

    override val layoutId: Int = R.layout.item_top_player
}