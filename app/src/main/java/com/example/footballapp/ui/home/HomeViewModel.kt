package com.example.footballapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.playerDetailsResponse.PlayerDetailsResponse
import com.example.footballapp.repository.FootballRepository

class HomeViewModel:ViewModel() {
    val player = FootballRepository.getPlayerDetails(44).asLiveData()
}