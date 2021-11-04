package com.example.footballapp.ui.league.standing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentStandingBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.league.LeagueViewModel

class StandingFragment : BaseFragment<FragmentStandingBinding>() {
    //    private val args: StandingFragmentArgs by navArgs()
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentStandingBinding
        get() = FragmentStandingBinding::inflate

    override fun setup() {}
}