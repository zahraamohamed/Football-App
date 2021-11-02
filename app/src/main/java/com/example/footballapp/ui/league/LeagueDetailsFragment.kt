package com.example.footballapp.ui.league

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentLeagueDetailsBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.home.HomeFragment
import com.example.footballapp.ui.league.matches.MatchesFragment
import com.example.footballapp.ui.league.scorers.ScorersFragment
import com.example.footballapp.ui.league.standing.StandingFragment
import com.google.android.material.tabs.TabLayoutMediator

class LeagueDetailsFragment : BaseFragment<FragmentLeagueDetailsBinding>() {
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLeagueDetailsBinding
        get() = FragmentLeagueDetailsBinding::inflate


    private val fragments = listOf(MatchesFragment(), ScorersFragment(), StandingFragment())
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

    val fragment = HomeFragment()
    private fun initViewPager() {
        val leagueDetailsFragmentAdapter = LeagueDetailsFragmentAdapter(this, fragments)
        binding.viewPager.adapter = leagueDetailsFragmentAdapter
    }

}