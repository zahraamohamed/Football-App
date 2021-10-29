package com.example.footballapp.ui.league.matches

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentMatchesBinding
import com.example.footballapp.ui.base.BaseFragment
import com.example.footballapp.ui.match.MatchViewModel


class MatchesFragment : BaseFragment<FragmentMatchesBinding>() {
    override val viewModel: MatchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMatchesBinding
        get() = FragmentMatchesBinding::inflate


    override fun setup() {
        binding?.apply {
            this.viewModel = viewModel
            this.lifecycleOwner = viewLifecycleOwner
            matchesRecycler.adapter = MatchesAdapter(mutableListOf(), viewModel)
        }
    }

}