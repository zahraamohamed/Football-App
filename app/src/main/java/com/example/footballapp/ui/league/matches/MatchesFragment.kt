package com.example.footballapp.ui.league.matches

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentMatchesBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueViewModel


class MatchesFragment : BaseFragment<FragmentMatchesBinding>() {
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMatchesBinding
        get() = FragmentMatchesBinding::inflate

    override fun setup() {
        binding.matchesRecycler.adapter = MatchesAdapter(mutableListOf(), viewModel)
        arguments?.getInt("LEAGUE_ID")?.let { leagueId ->
            viewModel.onLeagueClicked(leagueId)
            Log.v("MATCHES", leagueId.toString())
        }
    }
}