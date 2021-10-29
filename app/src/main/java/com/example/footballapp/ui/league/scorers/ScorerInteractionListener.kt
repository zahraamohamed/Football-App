package com.example.footballapp.ui.league.scorers
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.ui.base.BaseInteractionListener

interface ScorerInteractionListener : BaseInteractionListener {
    fun onClickScorer(scorer: Scorer)
}