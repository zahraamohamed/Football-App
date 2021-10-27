package com.example.footballapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    abstract val bindingInflater: (LayoutInflater) -> VB
    private lateinit var _binding: ViewDataBinding
    var binding: VB?
        get() = _binding as VB?
        set(value) = TODO()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(_binding.root)
    }
}