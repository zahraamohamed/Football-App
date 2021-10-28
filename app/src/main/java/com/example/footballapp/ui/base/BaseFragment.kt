package com.example.footballapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment<VB: ViewDataBinding, VM : ViewModel> : Fragment() {

    private lateinit var _binding : ViewDataBinding
    protected lateinit var viewModel : VM

    val binding : VB get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater,
            getFragment(),
            container,
            false
        )
        _binding.lifecycleOwner = viewLifecycleOwner
        viewModel = ViewModelProvider(this).get(getViewModel())
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    abstract fun setup()

    abstract fun getViewModel(): Class<VM>

    abstract fun getFragment(): Int

}