package com.example.footballapp.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.footballapp.BR

abstract class BaseAdapter<T>(
    private var items: List<T>,
    private val listener: BaseInteractionListener
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder>() {

    abstract val layoutId: Int

    fun setItem(newItems: List<T>) {
        items = newItems
        notifyDataSetChanged()
    }

    fun getItem() = items

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): BaseViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                layoutId,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (holder is ItemViewHolder ) {
                holder.binding.setVariable(BR.item, items[position])
                holder.binding.setVariable(BR.listener, listener)
        }
    }

    override fun getItemCount(): Int = items.size

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

}



