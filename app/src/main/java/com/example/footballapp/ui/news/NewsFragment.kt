package com.example.footballapp.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.footballapp.databinding.FragmentNewsBinding
import com.example.footballapp.databinding.FragmentTeamDetailsBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.teams.TeamDetailsAdapter
import com.example.footballapp.ui.teams.TeamViewModel


class NewsFragment :BaseFragment<FragmentNewsBinding>() {
    override val viewModel: NewsViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNewsBinding
        get() = FragmentNewsBinding::inflate

    override fun setup() {
        binding.recyclerNews.adapter =NewsAdapter(mutableListOf(), viewModel)
    }

}