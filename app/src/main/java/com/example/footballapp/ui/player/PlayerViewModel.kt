package com.example.footballapp.ui.player

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.playerDetailsResponse.PlayerDetailsResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Response

class PlayerViewModel : ViewModel() {

    val playerDetails = MutableLiveData<State<PlayerDetailsResponse?>>()

    fun onPlayerClicked(id: Int?) {
        id?.let {
            viewModelScope.launch {
                FootballRepository.getPlayerDetails(id).collect {
                    playerDetails.postValue(it)
                }
            }

        }
    }
}
