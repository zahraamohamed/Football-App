package com.example.footballapp.ui.base

import android.util.Log
import androidx.lifecycle.*
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.Status
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


abstract class BaseViewModel() : ViewModel() {

//    fun <T> collectValue(response: Flow<Status<T>>, theValue: MutableLiveData<Status<T?>>) =
//        viewModelScope.launch {
//            response
//                .flowOn(Dispatchers.IO)
//                .catch { Log.i("ERROR" , "error!") }
//                .collect {
//                    Log.i("hhhhhhhhhh" , it.toString())
//                    theValue.postValue(it)
//                }
//        }

}