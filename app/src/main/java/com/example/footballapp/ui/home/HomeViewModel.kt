package com.example.footballapp.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel(), HomeInteractionListener {

    var liveMatches = MutableLiveData<MatchesResponse>()
    var competitions = MutableLiveData<List<Competition>>()

    val clickItemMatch = MutableLiveData<Int?>()

    var itemsList: MutableLiveData<List<HomeItems<Any?>>> = MutableLiveData()

    init{
        getListAdapter()
    }

    private fun getListAdapter() {
        viewModelScope.launch {
            FootballRepository.getDailyMatch().collect{ liveMatches.value = it.toData() }
            FootballRepository.getAllCompetitions().collect{ competitions.value = it }

            itemsList.value = listOf(HomeItems(competitions.value , HomeItemsType.TYPE_COMPETITION) ,
                HomeItems(liveMatches.value?.matches, HomeItemsType.TYPE_LIVE_MATCH) )
        }
    }

    override fun onClickSeeMore() { }

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }




}