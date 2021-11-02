package com.example.footballapp.ui.home

import android.util.Log
import android.view.ViewGroup
import com.example.footballapp.BR
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.Matche
import com.example.footballapp.ui.base.BaseAdapter


class HomeNestedAdapter(
    private var items: List<HomeItems<Any>>,
    private val listener: HomeInteractionListener
) : BaseAdapter<Any>(items, listener) {

    override var layoutId: Int = 0

    fun setItemsNested(newHome: List<HomeItems<Any>>) {
        items = newHome
        Log.i("sssssssssssssSetItems" , items.toString())
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = HomeItemsType.values()[getItemViewType(viewType)].layout
        Log.i("sssssssssssssLayout" , layoutId.toString())
        return super.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
          bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        when (getItemViewType(position)) {
            HomeItemsType.TYPE_COMPETITION.index -> {
                holder.binding.setVariable(BR.adapter,
                    (items[position].item )?.let { CompetitionAdapter(it as List<Competition>, listener) })
            }
            HomeItemsType.TYPE_LIVE_MATCH.index -> {
                holder.binding.setVariable(BR.adapter,
                    (items[position].item )?.let { LiveMatchAdapter(it as List<Matche>, listener) })
            }
            else -> {

            }
        }

    }

    override fun getItemViewType(position: Int): Int  = items[position].type


}