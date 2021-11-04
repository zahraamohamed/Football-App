package com.example.footballapp.ui.league.matches

import com.example.footballapp.ui.base.BaseInteractionListener

interface MatchInteractionListener : BaseInteractionListener {
    fun onClickMatch(id: Int?)
    fun onMatchLoad(id: Int?)
}