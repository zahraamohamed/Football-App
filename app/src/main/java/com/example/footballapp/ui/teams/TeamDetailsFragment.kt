package com.example.footballapp.ui.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.footballapp.databinding.FragmentTeamDetailsBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.player.PlayerDetailsFragmentDirections


class TeamDetailsFragment : BaseFragment<FragmentTeamDetailsBinding>() {
    override val viewModel: TeamViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTeamDetailsBinding
        get() = FragmentTeamDetailsBinding::inflate

    override fun setup() {
        binding.teamsRecycler.adapter = TeamDetailsAdapter(mutableListOf(), viewModel)
     //   binding.showMoreTeam.setOnClickListener {
      //      val action = TeamDetailsFragmentDirections.actionTeamDetailsFragmentToWebSearchFragment(7879)
      //      Navigation.findNavController(it).navigate(action)
    //    }
    }
}