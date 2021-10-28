package com.example.footballapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.footballapp.model.Status
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.competitionsResponse.CompetitionsResponse
import com.example.footballapp.repository.Repository
import com.example.footballapp.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel(), CompetitionInteractionListener {

    var competitionsData = MutableLiveData<Status<CompetitionsResponse?>>()

    init {
        getCompetitionsData()
    }

    private fun getCompetitionsData() {
        viewModelScope.launch {
            Repository.getAllCompetitions().collect {
                competitionsData.postValue(it)
            }
        }
    }

    override fun onClickCompetition(competition: Competition) {

    }

}