package com.example.footballapp.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.repository.Repository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


abstract class BaseViewModel() : ViewModel() {

    private val repository :Repository()
    abstract  val football : MutableLiveData<Any>

    override fun onCleared() {
        super.onCleared()
       viewModelScope.cancel()
    }

     fun <T>coroutine(){
        viewModelScope.launch {
           repository.getRandomMatch<T>().collect {
               football.postValue(it)
           }
        }


    }






}