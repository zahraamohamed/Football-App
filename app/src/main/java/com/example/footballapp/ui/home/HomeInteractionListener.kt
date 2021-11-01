package com.example.footballapp.ui.home

import com.example.footballapp.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onClickSeeMore()
    fun onClickItemMatch(matchId: Int?)
}