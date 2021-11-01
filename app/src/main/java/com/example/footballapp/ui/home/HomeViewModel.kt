package com.example.footballapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.model.domain.matchesResponse.MatchesResponse
import com.example.footballapp.repository.FootballRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class HomeViewModel: ViewModel() , HomeInteractionListener {

    var liveMatches = MutableLiveData<MatchesResponse>()
    var competitions = MutableLiveData<CompetitionsResponse>()

    val clickItemMatch = MutableLiveData<Int>()

    var itemsList: MutableLiveData<List<HomeItems<Any?>>> = MutableLiveData()

    init{
        getListAdapte()
    }

    private fun getListAdapte() {
        viewModelScope.launch {
            FootballRepository.getAllMatch().collect{ liveMatches.value = it.toData() }
            FootballRepository.getAllCompetitions().collect{ competitions.value = it.toData() }

            itemsList.value = listOf(HomeItems(competitions.value?.competitions , HomeItemsType.TYPE_COMPETITION) ,
                HomeItems(liveMatches.value?.matches, HomeItemsType.TYPE_LIVE_MATCH) )
        }
    }

    override fun onClickSeeMore() { }

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }


}