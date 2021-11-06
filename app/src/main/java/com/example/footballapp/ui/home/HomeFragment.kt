package com.example.footballapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.footballapp.databinding.FragmentHomeBinding
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.Matche
import com.example.footballapp.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {
        initNestedAdapter()
        observeValue()

        viewModel.navigateToDetails.observe(this, {
            it?.getContentIfNotHandled()?.let { leagueId ->
                val action = HomeFragmentDirections.actionHomeFragmentToLeagueFragment(leagueId)
                this.findNavController().navigate(action)
            }
        })
    }

    private fun initNestedAdapter() {
        binding.recyclerViewHome.adapter = HomeNestedAdapter(mutableListOf(), viewModel, viewModel)

        observeListsForAdapter()
    }

    private fun observeListsForAdapter() {
        (binding.recyclerViewHome.adapter as HomeNestedAdapter?)?.let { adapter ->

            viewModel.competitions.observe(this@HomeFragment) { items ->
                items?.toData()?.competitions?.let { adapter.setItem(HomeItems.CompetitionType(it)) }
            }

            viewModel.liveMatches.observe(this@HomeFragment) { items ->
                items?.toData()?.matches?.let { adapter.setItem(HomeItems.LiveMatchType(it)) }
            }

            viewModel.topPlayer.observe(this@HomeFragment) { items ->
                items?.toData()?.scorers?.let { adapter.setItem(HomeItems.TopPlayerType(it)) }
            }

        }
    }


    private fun observeValue() {
//        viewModel.clickItemMatch.observe(this, {
//            Navigation.findNavController(this).navigate(
//                MatchDetailsFragmentDirections.actionHomeFragmentToMatchDetailsFragment(it)
//            )
//        })
    }

}