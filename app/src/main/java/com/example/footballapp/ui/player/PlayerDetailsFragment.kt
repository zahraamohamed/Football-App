package com.example.footballapp.ui.player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentPlayerDetailsBinding
import com.example.footballapp.ui.base.BaseFragment

class PlayerDetailsFragment: BaseFragment<FragmentPlayerDetailsBinding>() {
    override val viewModel: PlayerViewModel by viewModels()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPlayerDetailsBinding
        get() = FragmentPlayerDetailsBinding::inflate

    override fun setup() {
    }
}