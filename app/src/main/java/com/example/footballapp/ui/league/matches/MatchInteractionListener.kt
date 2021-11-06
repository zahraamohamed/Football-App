package com.example.footballapp.ui.league.matches

import androidx.lifecycle.LiveData
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.SpecificCompetitionMatchesResponse
import com.example.footballapp.ui.base.BaseInteractionListener

interface MatchInteractionListener : BaseInteractionListener {
    fun onClickMatch(id: Int?)
    fun onMatchLoad(id: Int?)


}