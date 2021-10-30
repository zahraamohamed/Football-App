package com.example.footballapp.ui.match


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentMatchDetailsBinding
import com.example.footballapp.ui.base.BaseFragment

class MatchDetailsFragment: BaseFragment<FragmentMatchDetailsBinding>() {
    override val viewModel: MatchViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentMatchDetailsBinding
        get() = FragmentMatchDetailsBinding::inflate

    override fun setup() {
        binding.apply {
            viewmodel = viewModel
            lifecycleOwner= lifecycleOwner
        }
    }
}