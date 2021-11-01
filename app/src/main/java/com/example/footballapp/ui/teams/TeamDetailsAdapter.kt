package com.example.footballapp.ui.teams

import com.example.footballapp.R
import com.example.footballapp.model.domain.teamDetailsResponse.Squad
import com.example.footballapp.ui.base.BaseAdapter

class TeamDetailsAdapter(
    items: List<Squad>,
    listener: ITeamDetailsInteractionListener
) :
    BaseAdapter<Squad>(items, listener) {
    override val layoutId: Int = R.layout.item_team_details
}