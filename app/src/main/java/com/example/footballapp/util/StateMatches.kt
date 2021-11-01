package com.example.footballapp.util

import com.example.footballapp.R

enum class StateMatches(val cardColor: Int) {
    SCHEDULED(R.color.card_color_green),
    LIVE(R.color.card_color_blue),
    IN_PLAY(R.color.card_color_blue),
    PAUSED(R.color.card_color_light_blue),
    FINISHED(R.color.card_color_gray),
    POSTPONED(R.color.card_color_purpler),
    SUSPENDED(R.color.card_color_red),
    CANCELED(R.color.card_color_gray);

}