package com.example.footballapp.ui.league.matches

import com.example.footballapp.ui.base.BaseInteractionListener
import com.example.footballapp.model.domain.specificCompetitionMatchesResponse.Matche

interface MatchInteractionListener  : BaseInteractionListener {
    fun onClickMatch(match: Matche)
}