package com.example.footballapp.ui.home

import com.example.footballapp.R
import com.example.footballapp.model.domain.matchesResponse.Matche
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.base.BaseInteractionListener

class LiveMatchAdapter(
    items: List<Matche>,
    listener: HomeInteractionListener
) : BaseAdapter<Matche>(items, listener) {

    override val layoutId: Int = R.layout.item_live_match
}