package com.example.footballapp.ui.home

import androidx.lifecycle.*
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel(), HomeInteractionListener {

    var liveMatches = MutableLiveData<MatchesResponse>()
    var competitions = MutableLiveData<CompetitionsResponse>()

    val clickItemMatch = MutableLiveData<Int?>()

    val filters: LiveData<List<Competition>> = Transformations.map(competitions) {
        filtersData(it.competitions)
    }

    var itemsList: MutableLiveData<List<HomeItems<Any?>>> = MutableLiveData()

    init {
        initListsForAdapter()
    }

    private fun initListsForAdapter() {
        viewModelScope.launch {
            FootballRepository.getDailyMatch().collect { liveMatches.value = it.toData() }
            FootballRepository.getAllCompetitions().collect { competitions.value = it.toData() }
            addToListAdapter()
        }
    }

    private fun addToListAdapter() {
        if (liveMatches.value != null && competitions.value != null)
            itemsList.value = listOf(
                HomeItems(competitions.value?.competitions, HomeItemsType.TYPE_COMPETITION),
                HomeItems(liveMatches.value?.matches, HomeItemsType.TYPE_LIVE_MATCH))
    }

    override fun onClickSeeMore() {}

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }

    private fun filtersData(competitions: List<Competition>?): List<Competition>? {
        return competitions?.filter { it.emblemUrl != null }
    }
}