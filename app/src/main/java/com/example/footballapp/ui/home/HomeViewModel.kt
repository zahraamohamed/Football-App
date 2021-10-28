package com.example.footballapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.Status
import com.example.footballapp.model.domain.playerDetailsResponse.PlayerDetailsResponse
import com.example.footballapp.repository.Repository

class HomeViewModel:ViewModel() {

    private val repository = Repository()


    val popularMovies: LiveData<Status<PlayerDetailsResponse?>> = repository.getPlayer().asLiveData()
}