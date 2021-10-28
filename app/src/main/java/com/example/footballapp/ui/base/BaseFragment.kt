package com.example.footballapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.footballapp.BR


abstract class BaseFragment<VDB : ViewDataBinding>() : Fragment() {

    private lateinit var _binding: VDB

    protected val binding get() = _binding

    abstract val viewModel: ViewModel

    abstract val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> VDB


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = bindingInflater(inflater, container, false)
        _binding.setVariable(BR.viewModel, viewModel)
        _binding.lifecycleOwner = this
        setup()
        return _binding.root
    }

    abstract fun setup()


}