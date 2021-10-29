package com.example.footballapp.ui.league.matches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentMatchesBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueViewModel
import com.example.footballapp.ui.league.scorers.ScorerAdapter
import com.example.footballapp.ui.match.MatchViewModel


class MatchesFragment : BaseFragment<FragmentMatchesBinding>() {
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMatchesBinding
        get() = FragmentMatchesBinding::inflate


    override fun setup() {
        val adapter = MatchesAdapter(mutableListOf(), viewModel)
        binding.apply {
            matchesRecycler.adapter  = adapter
        }
    }
}