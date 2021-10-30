package com.example.footballapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.footballapp.databinding.FragmentHomeBinding
import com.example.footballapp.model.State
import com.example.footballapp.model.domain.competitionsResponse.Competition
import com.example.footballapp.model.domain.matchesResponse.AwayTeam
import com.example.footballapp.model.domain.matchesResponse.Matche
import com.example.footballapp.model.domain.matchesResponse.Season
import com.example.footballapp.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeInteractionListener {
    override val viewModel: HomeViewModel by viewModels()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun setup() {

        val itemsList: MutableList<HomeItems<Any>> = mutableListOf()

//        viewModel.player.observe(this , { obs ->
//            obs.toData()?.matches?.let {
//                itemsList.add(HomeItems(it , HomeItemType.TYPE_LIVE_MATCH))
//            }
//        })

        itemsList.add(HomeItems(listOf(Competition()) , HomeItemType.TYPE_COMPETITION))

        itemsList.add(HomeItems(
            listOf(
                Matche(AwayTeam(1 , "shahad") , null , "" , null
                , 1 , "55" , 34 , null , null , null ,
                Season(4 , "45" , 6 , "56" , "ttt")) ,
                Matche(AwayTeam(1 , "shahad") , null , "" , null
                    , 1 , "55" , 34 , null , null , null ,
                    Season(4 , "45" , 6 , "56" , "ttt"))
            ) ,
            HomeItemType.TYPE_LIVE_MATCH))

        val adapter = HomeNestedAdapter(itemsList, this)

        binding.recyclerViewHome.adapter = adapter
    }


}