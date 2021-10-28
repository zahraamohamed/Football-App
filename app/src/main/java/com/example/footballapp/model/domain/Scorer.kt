package com.example.footballapp.model.domain


import com.google.gson.annotations.SerializedName

data class Scorer(
    @SerializedName("numberOfGoals")
    var numberOfGoals: Int? = 0,
    @SerializedName("player")
    var player: Player? = Player(),
    @SerializedName("team")
    var team: Team? = Team()
)