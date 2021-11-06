package com.example.footballapp.ui.league.scorers

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.footballapp.databinding.FragmentScorersBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueFragmentDirections


class ScorersFragment : BaseFragment<FragmentScorersBinding>() {
    override val viewModel: ScorersViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScorersBinding
        get() = FragmentScorersBinding::inflate

    override fun setup() {
        binding.scorerRecycler.adapter = ScorerAdapter(mutableListOf(), viewModel)
        arguments?.getInt("LEAGUE_ID")?.let { leagueId ->
            viewModel.onScorerLoad(leagueId)
        }

        viewModel.navigateToPlayerDetails.observe(this, Observer {
            it.getContentIfNotHandled()?.let { id ->
                val action =
                    LeagueFragmentDirections.actionLeagueFragmentToPlayerDetailsFragment(id)
                findNavController().navigate(action)
            }
        })
    }
}