package com.example.footballapp.ui.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.repository.FootballRepository

class PlayerViewModel : ViewModel() {

    val playerDetails = FootballRepository.getPlayerDetails(44).asLiveData()
}