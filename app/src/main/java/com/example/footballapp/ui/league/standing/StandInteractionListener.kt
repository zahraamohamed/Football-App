package com.example.footballapp.ui.league.standing

import com.example.footballapp.model.domain.teamRankResponse.Table
import com.example.footballapp.ui.base.BaseInteractionListener

interface StandInteractionListener : BaseInteractionListener {
    fun onClickStand(table: Table)
}