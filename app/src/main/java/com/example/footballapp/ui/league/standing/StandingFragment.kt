package com.example.footballapp.ui.league.standing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.footballapp.databinding.FragmentStandingBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueFragment
import com.example.footballapp.ui.league.LeagueFragmentDirections
import com.example.footballapp.ui.league.LeagueViewModel

class StandingFragment : BaseFragment<FragmentStandingBinding>() {
    override val viewModel: StandingViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStandingBinding
        get() = FragmentStandingBinding::inflate

    override fun setup() {
        binding.standingRecycler.adapter =
            StandAdapter(mutableListOf(), viewModel)
        viewModel.onScorerLoad(arguments?.getInt("LEAGUE_ID"))

        viewModel.navigateToTeamDetails.observe(this, {
            it.getContentIfNotHandled()?.let { teamId ->
                val action = LeagueFragmentDirections.actionLeagueFragmentToTeamDetailsFragment(teamId)
                findNavController().navigate(action)
            }
        })
    }



}