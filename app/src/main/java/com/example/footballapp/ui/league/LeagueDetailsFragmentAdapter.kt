package com.example.footballapp.ui.league

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class LeagueDetailsFragmentAdapter(container : Fragment, private val fragmentList: List<Fragment> )
    : FragmentStateAdapter(container) {

    override fun getItemCount() = fragmentList.size

    override fun createFragment(position: Int) = fragmentList[position]
}