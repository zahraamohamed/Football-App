package com.example.footballapp.ui.home

import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.ui.base.BaseInteractionListener

interface CompetitionInteractionListener : BaseInteractionListener {

    fun onClickCompetition(competition: Competition)

}