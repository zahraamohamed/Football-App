package com.example.footballapp.ui.home

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.example.footballapp.BR
import com.example.footballapp.R
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.Matche
import com.example.footballapp.ui.base.BaseAdapter


class HomeNestedAdapter(
    private var items: List<HomeItems<Any>>,
    private val listener: HomeInteractionListener
) : BaseAdapter<Any>(items, listener) {

    override var layoutId: Int = 0

    @SuppressLint("NotifyDataSetChanged")
    fun setItemsNested(newHome: List<HomeItems<Any>>) {
        items = newHome
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = getLayoutId(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getLayoutId(viewType: Int): Int =
        when (viewType) {
            VIEW_TYPE_COMPETITION -> R.layout.items_horizontal_competition_host
            VIEW_TYPE_LIVE_MATCH -> R.layout.items_horizontal_host
            else -> R.layout.items_horizontal_host
        }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is ItemViewHolder)
            bind(holder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        when (items[position].type) {
            HomeItemsType.TYPE_COMPETITION -> {
                holder.binding.setVariable(BR.adapter,
                    CompetitionAdapter(items[position].item as List<Competition>, listener))
            }
            HomeItemsType.TYPE_LIVE_MATCH -> {
                holder.binding.setVariable(
                    BR.adapter,
                    LiveMatchAdapter(items[position].item as List<Matche>, listener))
            }
            else -> {

            }
        }

    }

    override fun getItemViewType(position: Int): Int =
        when (items[position].type) {
            HomeItemsType.TYPE_COMPETITION -> VIEW_TYPE_COMPETITION
            HomeItemsType.TYPE_LIVE_MATCH -> VIEW_TYPE_LIVE_MATCH
            else -> VIEW_TYPE_ANONYMOUS
        }


    companion object {
        private const val VIEW_TYPE_COMPETITION = 1
        private const val VIEW_TYPE_LIVE_MATCH = 2
        private const val VIEW_TYPE_ANONYMOUS = 3
    }


}