package com.example.footballapp.ui.home

import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.Matche
import com.example.footballapp.model.domain.scorerRankResponse.Scorer


sealed class HomeItems(val type: HomeItemsType) {
    class CompetitionType(val items: List<Competition>) : HomeItems(HomeItemsType.TYPE_COMPETITION)
    class LiveMatchType(val items: List<Matche>) : HomeItems(HomeItemsType.TYPE_LIVE_MATCH)
    class TopPlayerType(val items: List<Scorer>) : HomeItems(HomeItemsType.TYPE_TOP_PLAYER)
}