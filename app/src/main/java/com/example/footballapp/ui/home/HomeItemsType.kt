package com.example.footballapp.ui.home

import com.example.footballapp.R

enum class HomeItemsType(val index: Int, val layout: Int) {
    TYPE_COMPETITION(0, R.layout.items_horizontal_competition_host),
    TYPE_LIVE_MATCH(1, R.layout.items_horizontal_host);
}