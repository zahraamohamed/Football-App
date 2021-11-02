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

        viewModel.navigateToDetails.observe(this, {
            it?.getContentIfNotHandled()?.let { leagueId ->
                val action = HomeFragmentDirections.actionHomeFragmentToViewPagerFragment(leagueId)
                this.findNavController().navigate(action)
            }
        })
        //  observeValue()
    }

    private fun initNestedAdapter() {
        val itemsList: List<HomeItems<Any>> =
            listOf(
                HomeItems(listOf(Competition()), HomeItemsType.TYPE_COMPETITION),
                HomeItems(listOf(Matche()), HomeItemsType.TYPE_LIVE_MATCH)
            )
        binding.recyclerViewHome.adapter = HomeNestedAdapter(itemsList, viewModel, viewModel)
    }

//    private fun observeValue() {
//        viewModel.clickItemMatch.observe(this, {
//            Navigation.findNavController(this).navigate(
//                MatchDetailsFragmentDirections.actionHomeFragmentToMatchDetailsFragment(it)
//            )
//        })
//    }

}