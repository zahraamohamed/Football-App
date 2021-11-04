package com.example.footballapp.ui.league.scorers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.footballapp.databinding.FragmentScorersBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.viewPager.ViewPagerFragmentDirections

class ScorersFragment : BaseFragment<FragmentScorersBinding>() {
    override val viewModel: ScorersViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScorersBinding
        get() = FragmentScorersBinding::inflate

    override fun setup() {
//        viewModel.leagueId.value = leagueId
        binding.scorerRecycler.adapter = ScorerAdapter(mutableListOf(), viewModel)
//        val action = ScorersFragmentDirections.actionScorersFragmentToPlayerDetailsFragment(7879)
//        findNavController().navigate(action)

        viewModel.navigateToPlayerDetails.observe(this, Observer {
            it.getContentIfNotHandled()?.let { id ->
                val action =
                    ViewPagerFragmentDirections.actionViewPagerFragmentToPlayerDetailsFragment(id)
                findNavController().navigate(action)
            }
        })
    }
}