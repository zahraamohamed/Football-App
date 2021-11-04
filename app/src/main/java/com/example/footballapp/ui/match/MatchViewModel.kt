package com.example.footballapp.ui.match


import androidx.lifecycle.*
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.model.domain.specificMatchDetailsResponse.SpecificMatchDetailsResponse
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MatchViewModel:ViewModel() {
    val matchDetails = MutableLiveData<State<SpecificMatchDetailsResponse?>>()

    fun onMatchDetailsLoad(id: Int?) {
        viewModelScope.launch {
            FootballRepository.getSpecificMatchDetails(id).collect {
                matchDetails.postValue(it)
            }
        }
    }
}