package com.example.footballapp.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.footballapp.databinding.FragmentTeamDetailsBinding
import com.example.footballapp.ui.base.BaseFragment


class TeamDetailsFragment : BaseFragment<FragmentTeamDetailsBinding>() {
    private val args: TeamDetailsFragmentArgs by navArgs()
    override val viewModel: TeamViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTeamDetailsBinding
        get() = FragmentTeamDetailsBinding::inflate

    override fun setup() {
        viewModel.onLoadTeam(args.teamId)
        binding.teamsRecycler.adapter = TeamDetailsAdapter(mutableListOf(), viewModel)
    }
}