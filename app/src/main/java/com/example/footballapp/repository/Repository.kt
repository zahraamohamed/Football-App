package com.example.footballapp.repository

import com.example.footballapp.model.Status
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository {
    suspend fun <T>getRandomMatch() :Flow<Status<T?>>{
        return flow {
           // emit(....)
        }
    }


}