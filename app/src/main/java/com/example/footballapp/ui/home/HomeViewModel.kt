package com.example.footballapp.ui.home

import androidx.lifecycle.*
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel : ViewModel(), HomeInteractionListener {

    private var liveMatches = MutableLiveData<State<MatchesResponse?>>()
    private var competitions = MutableLiveData<List<Competition>>()

    val clickItemMatch = MutableLiveData<Int?>()

    var _itemsList: MutableLiveData<List<HomeItems<Any>>> = MutableLiveData()
    val itemsList: LiveData<List<HomeItems<Any>>> = _itemsList


    init {
        setListsAdapter()
    }

    private fun setListsAdapter() {
        viewModelScope.launch {
            FootballRepository.getDailyMatch().collect { liveMatches.value = it }
            FootballRepository.filterDataCompetitions().collect { competitions.value = it }

            _itemsList.value =
                listOf(HomeItems(competitions.value, HomeItemsType.TYPE_COMPETITION.index),
                       HomeItems(liveMatches.value?.toData()?.matches, HomeItemsType.TYPE_LIVE_MATCH.index))

        }
    }

    override fun onClickSeeMore() {}

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }


}