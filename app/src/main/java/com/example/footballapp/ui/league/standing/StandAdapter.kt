package com.example.footballapp.ui.league.standing

import com.example.footballapp.R
import com.example.footballapp.model.domain.teamRankResponse.Standing
import com.example.footballapp.ui.base.BaseAdapter


class StandAdapter(
    val items: List<Standing>,
    val listener: StandInteractionListener,
    override val layoutId: Int = R.layout.item_standing
   ) : BaseAdapter<Standing>(items, listener)  {
}