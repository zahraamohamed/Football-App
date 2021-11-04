package com.example.footballapp.ui.league

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.footballapp.databinding.FragmentLeagueBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.matches.MatchesFragment
import com.example.footballapp.ui.league.scorers.ScorersFragment
import com.example.footballapp.ui.league.standing.StandingFragment
import com.google.android.material.tabs.TabLayoutMediator


class LeagueFragment : BaseFragment<FragmentLeagueBinding>() {
    private val args: LeagueFragmentArgs by navArgs()
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLeagueBinding
        get() = FragmentLeagueBinding::inflate

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
        val bundle = Bundle()
        bundle.putInt("LEAGUE_ID", args.leagueId)
        val matchesFragment = MatchesFragment()
        val scorersFragment = ScorersFragment()
        matchesFragment.arguments = bundle
        scorersFragment.arguments = bundle

        val fragments = listOf(
            matchesFragment,
            scorersFragment,
            StandingFragment()
        )
        val viewPagerAdapter = LeagueAdapter(this, fragments)
        binding.viewPager.adapter = viewPagerAdapter
        viewModel.onLeagueClicked(args.leagueId)
    }
}