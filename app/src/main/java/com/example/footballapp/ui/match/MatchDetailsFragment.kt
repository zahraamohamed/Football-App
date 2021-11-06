package com.example.footballapp.ui.match


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.footballapp.databinding.FragmentMatchDetailsBinding
import com.example.footballapp.ui.base.BaseFragment

class MatchDetailsFragment : BaseFragment<FragmentMatchDetailsBinding>() {
    private val args: MatchDetailsFragmentArgs by navArgs()
    override val viewModel: MatchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMatchDetailsBinding
        get() = FragmentMatchDetailsBinding::inflate

    override fun setup() {
        viewModel.onMatchDetailsLoad(args.matchId)
    }
}