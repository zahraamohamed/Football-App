package com.example.footballapp.ui.teams

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentMatchDetailsBinding
import com.example.footballapp.databinding.FragmentTeamDetailsBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.match.MatchViewModel


class TeamDetailsFragment : BaseFragment<FragmentTeamDetailsBinding>() {
    override val viewModel: TeameViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTeamDetailsBinding
        get() = FragmentTeamDetailsBinding::inflate

    override fun setup() {
        binding.apply{
            this.viewmodel = viewmodel
            this.lifecycleOwner = viewLifecycleOwner
            this.recyclerView.adapter = TeamDetailsAdapter(mutableListOf(),viewModel)
        }
    }

}