package com.example.footballapp.ui.league

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentLeagueDetailsBinding
import com.example.footballapp.ui.base.BaseFragment

class LeagueDetailsFragment:BaseFragment<FragmentLeagueDetailsBinding>(){
    override val viewModel: LeagueViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLeagueDetailsBinding
        get() = FragmentLeagueDetailsBinding::inflate

    override fun setup() {
    }

}