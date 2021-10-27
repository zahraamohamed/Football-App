package com.example.footballapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {

    abstract val theme: Int
    abstract val bindingInflater: (LayoutInflater) -> VB
    private lateinit var _binding: ViewDataBinding
    protected val binding get() = _binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        _binding.lifecycleOwner = this
        setTheme(theme)
        setContentView(_binding.root)
    }
}
