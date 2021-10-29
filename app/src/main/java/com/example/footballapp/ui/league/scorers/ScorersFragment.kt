package com.example.footballapp.ui.league.scorers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentScorersBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueViewModel

class ScorersFragment : BaseFragment<FragmentScorersBinding>() {
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScorersBinding
        get() = FragmentScorersBinding::inflate

    override fun setup() {
        binding?.apply {
            this.viewModel = viewModel
            this.lifecycleOwner = viewLifecycleOwner
            val adapter = ScorerAdapter(mutableListOf(),viewModel)
            scorerRecycler.adapter  = adapter
        }
    }

}