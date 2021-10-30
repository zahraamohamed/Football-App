package com.example.footballapp.ui.viewPager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentViewPagerBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.home.HomeFragment
import com.example.footballapp.ui.league.LeagueViewModel
import com.example.footballapp.ui.league.matches.MatchesFragment
import com.example.footballapp.ui.league.scorers.ScorersFragment
import com.example.footballapp.ui.league.standing.StandingFragment
import com.example.footballapp.ui.viewPager.viewPagerAdapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class ViewPager : BaseFragment<FragmentViewPagerBinding>() {
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentViewPagerBinding
        get() = FragmentViewPagerBinding :: inflate

    val fragments = listOf(MatchesFragment(),ScorersFragment(),StandingFragment())
    val tabLayoutTitles = listOf("Matches","Scorers","Standings")


    override fun setup() {
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayoutLol, binding.viewPager){ tab, position ->
            tab.text = tabLayoutTitles[position]
        }.attach()

    }

    val fragment = HomeFragment()
    private fun initViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(this, fragments)
        binding.viewPager.adapter = viewPagerAdapter
    }

}