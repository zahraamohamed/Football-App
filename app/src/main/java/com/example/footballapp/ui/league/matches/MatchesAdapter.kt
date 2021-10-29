package com.example.footballapp.ui.league.matches

import com.example.footballapp.R
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.base.BaseInteractionListener
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche

class MatchesAdapter(
    items: List<Matche>,
    listener: MatchInteractionListener) : BaseAdapter<Matche>(items, listener) {
    override val layoutId: Int = R.layout.item_match
    }
