package com.example.footballapp.ui.viewPager

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
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
    val args: ViewPagerArgs by navArgs()
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentViewPagerBinding
        get() = FragmentViewPagerBinding::inflate

    private val tabLayoutTitles = listOf("Matches", "Scorers", "Standings")


    override fun setup() {
        initViewPager()
        initTabLayout()
    }

    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayoutLol, binding.viewPager) { tab, position ->
            tab.text = tabLayoutTitles[position]
        }.attach()

    }

    private fun initViewPager() {
        val fragments = listOf(
            MatchesFragment(args.leagueId),
            ScorersFragment(args.leagueId),
            StandingFragment(args.leagueId)
        )
        val viewPagerAdapter = ViewPagerAdapter(this, fragments)
        binding.viewPager.adapter = viewPagerAdapter
        viewModel.onLeagueClicked(args.leagueId)
    }

}