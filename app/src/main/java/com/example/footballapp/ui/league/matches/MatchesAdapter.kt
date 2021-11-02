package com.example.footballapp.ui.league.matches

import com.example.footballapp.R
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.home.HomeInteractionListener

class MatchesAdapter(
    items: List<Matche>,
    listener: HomeInteractionListener
) : BaseAdapter<Matche>(items, listener) {
    override val layoutId: Int = R.layout.item_match
}
