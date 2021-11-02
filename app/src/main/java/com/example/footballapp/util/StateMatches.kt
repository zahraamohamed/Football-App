package com.example.footballapp.util

import com.example.footballapp.R

enum class StateMatches(val cardColor: Int) {
    SCHEDULED(R.drawable.shape_item_match_scheduled),
    LIVE(R.drawable.shape_item_live_match),
    IN_PLAY(R.drawable.shape_item_live_match),
    PAUSED(R.drawable.shape_item_match_paused),
    FINISHED(R.drawable.shape_item_match_finished),
    POSTPONED(R.drawable.shape_item_match_postponed),
    SUSPENDED(R.drawable.shape_item_match_suspended),
    CANCELED(R.drawable.shape_item_match_finished);
}