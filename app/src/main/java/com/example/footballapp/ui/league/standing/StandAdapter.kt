package com.example.footballapp.ui.league.standing


import com.example.footballapp.R
import com.example.footballapp.model.domain.teamRankResponse.Standing
import com.example.footballapp.ui.base.BaseAdapter


class StandAdapter(
    val items: List<Standing>, val listener: StandingInteractionListener,
   ) : BaseAdapter<Standing>(items, listener)  {

    override val layoutId: Int = R.layout.item_standing
}

