package com.example.footballapp.repository

import com.example.footballapp.model.State
import com.example.footballapp.model.domain.footballNewsResponse.FootballResponse
import com.example.footballapp.model.domain.teamRankResponse.TeamRankResponse
import com.example.footballapp.model.network.API
import com.example.footballapp.model.network.NewsApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

object NewsFootballRepository {


    fun getFootballNews(
        country: String = "gb",
        category: String = "sports"
    ): Flow<State<FootballResponse?>> =
        NewsFootballRepository.wrapWithFlow {
            NewsApi.newsService.getFootballNews(
                country,
                category
            )
        }

    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {
            emit(State.Loading)
            emit(checkIsSuccessful(function()))
        }

    private fun <T> checkIsSuccessful(response: Response<T>): State<T?> =
        try {
            if (response.isSuccessful) {
                State.Success(response.body())
            } else {
                State.Error(response.message())
            }
        } catch (e: Exception) {
            State.Error(e.message.toString())
        }
}