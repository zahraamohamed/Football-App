package com.example.footballapp.ui.home

import com.example.footballapp.model.domain.footballNewsResponse.Article
import com.example.footballapp.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onClickItemMatch(matchId: Int?)
    fun onNewsClick(articleDetails: Article)
    fun onLeagueClicked(leagueId: Int?, leagueName: String?=null )
}