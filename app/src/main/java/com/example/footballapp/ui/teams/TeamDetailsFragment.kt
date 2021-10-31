package com.example.footballapp.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentTeamDetailsBinding
import com.example.footballapp.ui.base.BaseFragment


class TeamDetailsFragment : BaseFragment<FragmentTeamDetailsBinding>() {
    override val viewModel: TeamViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTeamDetailsBinding
        get() = FragmentTeamDetailsBinding::inflate

    override fun setup() {

        binding.teamsRecycler.adapter = TeamDetailsAdapter(mutableListOf(), viewModel)
    }
}