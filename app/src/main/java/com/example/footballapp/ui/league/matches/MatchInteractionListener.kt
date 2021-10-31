package com.example.footballapp.ui.league.matches

import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche
import com.example.footballapp.ui.base.BaseInteractionListener

interface MatchInteractionListener : BaseInteractionListener {
    fun onClickMatch(match: Matche)
}