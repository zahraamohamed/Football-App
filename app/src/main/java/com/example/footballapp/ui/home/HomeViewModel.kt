package com.example.footballapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.repository.FootballRepository

class HomeViewModel:ViewModel() {

    val player = FootballRepository.getAllMatch().asLiveData()


}