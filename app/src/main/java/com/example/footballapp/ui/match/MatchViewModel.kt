package com.example.footballapp.ui.match


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.domain.specificMatchDetailsResponse.SpecificMatchDetailsResponse
import com.example.footballapp.repository.FootballRepository

class MatchViewModel:ViewModel() {

    val matchDetails= FootballRepository.getSpecificMatchDetails(204950).asLiveData()


}