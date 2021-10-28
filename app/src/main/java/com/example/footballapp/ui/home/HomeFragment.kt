package com.example.footballapp.ui.home

import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentHomeBinding
import com.example.footballapp.ui.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {

    override val layoutId: Int = R.layout.fragment_home

    override fun getViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun setup() {
        binding?.apply {
            recyclerOfCompetitions.adapter =
                CompetitionAdapter(mutableListOf(), this@HomeFragment.viewModel)
        }
    }


}