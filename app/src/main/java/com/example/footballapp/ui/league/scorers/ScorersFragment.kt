package com.example.footballapp.ui.league.scorers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentScorersBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueViewModel

class ScorersFragment : BaseFragment<FragmentScorersBinding>() {
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScorersBinding
        get() = FragmentScorersBinding::inflate

    override fun setup() {
        binding.scorerRecycler.adapter = ScorerAdapter(mutableListOf(), viewModel)
    }
}

