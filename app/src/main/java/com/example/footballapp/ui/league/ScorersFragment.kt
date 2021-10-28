package com.example.footballapp.ui.league

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.footballapp.R
import com.example.footballapp.databinding.FragmentScorsBinding
import com.example.footballapp.ui.base.BaseFragment


class ScorersFragment : BaseFragment<FragmentScorsBinding,ScorerViewModel>() {

    override fun setup() {

    }

    override fun getFragment(): Int = R.layout.fragment_scors
    override fun getViewModel(): Class<ScorerViewModel> = ScorerViewModel::class.java
}