package com.example.footballapp.ui.home

import com.example.footballapp.BR
import com.example.footballapp.R
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.ui.base.BaseAdapter

class CompetitionAdapter(
    val items: List<Competition>,
    val viewModel: HomeViewModel,
    listener: HomeInteractionListener) : BaseAdapter<Competition>(items, listener) {
    override val layoutId: Int = R.layout.item_competition

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        (holder as ItemViewHolder).binding.apply {
            setVariable(BR.item, items[position])
            setVariable(BR.viewModel, viewModel)
        }
    }
}