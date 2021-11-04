package com.example.footballapp.ui.league.scorers

import androidx.navigation.Navigation
import com.example.footballapp.R
import com.example.footballapp.databinding.ItemScorerBinding
import com.example.footballapp.model.domain.scorerRankResponse.Scorer
import com.example.footballapp.ui.base.BaseAdapter

class ScorerAdapter(
    val items: List<Scorer>, listener: ScorerInteractionListener,
    override val layoutId: Int = R.layout.item_scorer

) : BaseAdapter<Scorer>(items, listener) {
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        val binding = (holder as ItemViewHolder).binding as ItemScorerBinding
       // binding.scorersCard.setOnClickListener {
           // val playerID = binding.item?.player?.id
           // val action = ScorersFragmentDirections.actionScorersFragmentToPlayerDetailsFragment(
           //     playerID ?: 3754
          //  )
        //    Navigation.findNavController(holder.itemView).navigate(action)
      //  }
    }
}

