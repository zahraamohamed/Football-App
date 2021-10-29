package com.example.footballapp.ui.league.scorers

import com.example.footballapp.R
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.ui.base.BaseInteractionListener

class ScorerAdapter(
    items: List<Scorer>, listener: BaseInteractionListener,
    override val layoutId: Int = R.layout.item_scorer
) : BaseAdapter<Scorer>(items, listener)

