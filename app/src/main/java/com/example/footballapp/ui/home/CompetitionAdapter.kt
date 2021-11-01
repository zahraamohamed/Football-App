package com.example.footballapp.ui.home

import com.example.footballapp.R
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.ui.base.BaseAdapter

class CompetitionAdapter(
    items: List<Competition>,
    listener: HomeInteractionListener) : BaseAdapter<Competition>(items, listener) {
    override val layoutId: Int = R.layout.item_competition
}