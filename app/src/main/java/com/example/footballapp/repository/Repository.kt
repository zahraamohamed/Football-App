package com.example.footballapp.repository

import android.util.Log
import com.example.footballapp.model.Status
import com.example.footballapp.model.network.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class Repository {
    fun getPlayer()= wrampWithFlow { API.apiService.getPlayerDetails(44)
   }




    private fun <T> wrampWithFlow(function: suspend () -> Response<T>)

            : Flow<Status<T?>>
            = flow {
        emit(Status.Loading)
        try{
            val result = function()
            if (result.isSuccessful){
                emit(Status.Success(result.body()))
                Log.i("hh", Status.Success(result.body()).toString())

            }

            else
                emit(Status.Error(result.message()))
            Log.i("hh", Status.Error(result.message()).toString())

        } catch (e:Exception){
            emit(Status.Error(e.message.toString()))
            Log.i("hh",e.message.toString())
        }
        Log.i("gg", API.apiService.getPlayerDetails(44).isSuccessful.toString())
    }

}