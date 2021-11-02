package com.example.footballapp.ui.home

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.footballapp.BR
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.ui.base.BaseAdapter
import com.example.footballapp.ui.league.matches.MatchesAdapter


class HomeNestedAdapter(
    private var items: List<HomeItems<Any>>,
    private val listener: HomeInteractionListener
) : BaseAdapter<Any>(items, listener) {

    override var layoutId: Int = 0

    fun setItemsNested(newHome: List<HomeItems<Any>>) {
        items = newHome
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = HomeItemsType.values()[getItemViewType(viewType)].layout
        return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        when (getItemViewType(position)) {
            HomeItemsType.TYPE_COMPETITION.index ->
                (items[position].item)?.let {  holder.binding.setVariable(BR.adapter,
                   CompetitionAdapter(it as List<Competition>, listener)) }
            HomeItemsType.TYPE_LIVE_MATCH.index -> items[position].item?.let {
                holder.binding.setVariable(BR.adapter , MatchesAdapter(it as List<Matche>, listener)) }
            else -> { }
        }

    }

    override fun getItemViewType(position: Int): Int = items[position].type


}

