package com.example.footballapp.ui.league.standing

import com.example.footballapp.ui.base.BaseInteractionListener

interface StandingInteractionListener : BaseInteractionListener {
    fun onClickStand(id: Int)
    fun onScorerLoad(id: Int?)
}
