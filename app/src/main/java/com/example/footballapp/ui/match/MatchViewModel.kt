package com.example.footballapp.ui.match


import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.footballapp.model.domain.specificMatchDetailsResponse.SpecificMatchDetailsResponse
import com.example.footballapp.repository.FootballRepository

class MatchViewModel:ViewModel() {

    //private  val matchId:Int = SpecificMatchDetailsResponse().match?.id!!.toInt()
    val matchDetails= FootballRepository.getSpecificMatchDetails(204950).asLiveData()


}