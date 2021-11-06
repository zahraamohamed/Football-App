package com.example.footballapp.ui.home

import com.example.footballapp.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onClickItemMatch(matchId: Int?)
}