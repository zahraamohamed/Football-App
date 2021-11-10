package com.example.footballapp.ui.player

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.playerDetailsResponse.PlayerDetailsResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {

    val playerDetails = MutableLiveData<State<PlayerDetailsResponse?>>()

    fun onPlayerClicked(id: Int?) {
        viewModelScope.launch {
            FootballRepository.getPlayerDetails(id).collect {
                playerDetails.postValue(it)
            }
        }
    }
}
