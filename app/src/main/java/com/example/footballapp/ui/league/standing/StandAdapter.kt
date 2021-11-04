package com.example.footballapp.ui.league.standing


import android.util.Log
import com.example.footballapp.BR
import com.example.footballapp.R
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.Matche
import com.example.footballapp.model.domain.teamRankResponse.Standing
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.home.CompetitionAdapter
import com.example.footballapp.ui.home.HomeItemsType
import com.example.footballapp.ui.home.LiveMatchAdapter


class StandAdapter(
    val items: List<Standing>, val listener: StandInteractionListener,
   ) : BaseAdapter<Standing>(items, listener)  {

    override val layoutId: Int = R.layout.item_standing
}

