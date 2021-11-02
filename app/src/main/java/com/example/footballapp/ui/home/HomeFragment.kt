package com.example.footballapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
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
      //  observeValue()
    }

    private fun initNestedAdapter(){
        val itemsList: List<HomeItems<Any>> =
            listOf(HomeItems(listOf(Competition()), HomeItemsType.TYPE_COMPETITION.index),
                HomeItems(listOf(Matche()), HomeItemsType.TYPE_LIVE_MATCH.index))

        binding.recyclerViewHome.adapter = HomeNestedAdapter(items = itemsList, this.viewModel)

    }



//    private fun observeValue() {
//        viewModel.clickItemMatch.observe(this, {
//            Navigation.findNavController(this).navigate(
//                MatchDetailsFragmentDirections.actionHomeFragmentToMatchDetailsFragment(it)
//            )
//        })
//    }

}