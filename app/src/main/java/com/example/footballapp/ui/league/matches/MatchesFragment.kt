package com.example.footballapp.ui.league.matches

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.footballapp.databinding.FragmentMatchesBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueViewModel
import com.example.footballapp.ui.viewPager.ViewPagerFragmentDirections


class MatchesFragment : BaseFragment<FragmentMatchesBinding>() {
    override val viewModel: MatchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMatchesBinding
        get() = FragmentMatchesBinding::inflate

    override fun setup() {
        binding.matchesRecycler.adapter = MatchesAdapter(mutableListOf(), viewModel)
        arguments?.getInt("LEAGUE_ID")?.let { leagueId ->
            viewModel.onMatchLoad(leagueId)
            Log.v("MATCHES", leagueId.toString())
        }

        viewModel.navigateToMatchDetails.observe(this, {
            it.getContentIfNotHandled()?.let { matchId ->
                val action = ViewPagerFragmentDirections.actionViewPagerFragmentToMatchDetailsFragment(matchId)
                findNavController().navigate(action)
            }
        })
    }
}