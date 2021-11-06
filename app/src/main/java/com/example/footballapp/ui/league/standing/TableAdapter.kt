package com.example.footballapp.ui.league.standing

import com.example.footballapp.R
import com.example.footballapp.model.domain.teamRankResponse.Table
import com.example.footballapp.ui.base.BaseAdapter

class TableAdapter(
    val items: List<Table>, val listener: StandingInteractionListener,
) : BaseAdapter<Table>(items, listener)  {

    override val layoutId: Int = R.layout.item_standing

}