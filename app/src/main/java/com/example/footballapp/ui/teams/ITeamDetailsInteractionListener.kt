package com.example.footballapp.ui.teams

import com.example.footballapp.model.domain.teamDetailsResponse.Squad
import com.example.footballapp.model.domain.teamDetailsResponse.TeamDetailsResponse
import com.example.footballapp.ui.base.BaseInteractionListener

interface ITeamDetailsInteractionListener:BaseInteractionListener {
    fun onLoadTeam(id: Int)
    fun onClickTeamPlayer(id:Int?)
}