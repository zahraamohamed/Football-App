package com.example.footballapp.ui.home

import androidx.lifecycle.*
import com.example.footballapp.model.State
import com.example.footballapp.model.State.*
import com.example.footballapp.repository.FootballRepository
import com.example.footballapp.util.Event


class HomeViewModel : ViewModel(), HomeInteractionListener {

    private val _navigateToDetails = MutableLiveData<Event<Pair<Int, String>>>()
    val navigateToDetails: LiveData<Event<Pair<Int, String>>> get() = _navigateToDetails
    val matches = FootballRepository.getDailyMatch().asLiveData()
    val competitions = FootballRepository.filterDataCompetitions().asLiveData()
    val topPlayer = FootballRepository.getCompetitionScorers(2021).asLiveData()
    val clickItemMatch = MutableLiveData<Int?>()

    var statusHome = MediatorLiveData<State<Any?>>().apply {
        addSource(competitions) { postValue(checkStatus(it)) }
        addSource(matches) { postValue(checkStatus(it)) }
        addSource(topPlayer) { postValue(checkStatus(it)) }
    }


    private fun <T> checkStatus(state: State<T>): State<T>? =
        when {
            state is Success -> Success(state.toData())

            (matches.value is Loading &&
                    topPlayer.value is Loading) -> Loading

            (matches.value is Error &&
                    topPlayer.value is Error) -> Error("Error!")

            else -> null
        }


    fun onLeagueClicked(leagueId: Int?, leagueName: String? = null) {
        _navigateToDetails.value = Event(Pair(leagueId ?: 0, leagueName ?: ""))
    }

    override fun onClickItemMatch(matchId: Int?) {
        clickItemMatch.postValue(matchId)
    }

}