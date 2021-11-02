package com.example.footballapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel(), HomeInteractionListener {

    var liveMatches = MutableLiveData<MatchesResponse?>()
    var competitions = MutableLiveData<List<Competition>>()

    val clickItemMatch = MutableLiveData<Int?>()
    var itemsList: MutableLiveData<List<HomeItems<Any>>> = MutableLiveData()

    init {
        setListsAdapter()
    }

    private fun setListsAdapter() {
        viewModelScope.launch {
            FootballRepository.getDailyMatch().collect { liveMatches.value = it.toData() }
            FootballRepository.filterDataCompetitions().collect { competitions.value = it }

            itemsList.value =
                listOf(
                    HomeItems(competitions.value, HomeItemsType.TYPE_COMPETITION.index),
                    HomeItems(liveMatches.value?.matches, HomeItemsType.TYPE_LIVE_MATCH.index),)

        }
    }

    override fun onClickSeeMore() {}

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }


}