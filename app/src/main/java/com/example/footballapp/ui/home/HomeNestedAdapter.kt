package com.example.footballapp.ui.home

import android.view.ViewGroup
import com.example.footballapp.BR
import com.example.footballapp.R
import com.example.footballapp.ui.base.BaseAdapter


class HomeNestedAdapter(
    private var items: MutableList<HomeItems>,
    private var viewModel: HomeViewModel,
    private val listener: HomeInteractionListener
) : BaseAdapter<Any>(items, listener) {

    override var layoutId: Int = 0

    fun setItem(newItems: HomeItems) {
        items.apply {
            add(newItems)
            sortBy { it.type }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = getLayoutId(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getLayoutId(viewType: Int): Int =
        when (viewType) {
            HomeItemsType.TYPE_COMPETITION.index -> R.layout.items_horizontal_competition_host
            HomeItemsType.TYPE_LIVE_MATCH.index -> R.layout.items_horizontal_live_match_host
            else -> R.layout.items_horizantal_news_host

        }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder, position)
    }

    private fun bind(holder: ItemViewHolder, position: Int) {
        when (val currentItem = items[position]) {
                is HomeItems.CompetitionType ->{
                    holder.binding.setVariable(BR.adapter, CompetitionAdapter(currentItem.items, viewModel, listener))
                }
                is HomeItems.LiveMatchType -> {
                    holder.binding.setVariable(BR.adapter, LiveMatchAdapter(currentItem.items, listener))
                }
                is HomeItems.NewsType -> {
                    holder.binding.setVariable(BR.adapter, NewsNestedAdapter(currentItem.items, listener))
                }
        }
    }

    override fun getItemViewType(position: Int): Int = items[position].type.index


}

