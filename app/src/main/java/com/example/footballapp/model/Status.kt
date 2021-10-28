package com.example.footballapp.model

sealed class Status<out T>{
        data class Success<T>(val data:T) : Status<T>()
        object Loading:Status<Nothing>()
        data class Error(val message: String):Status<Nothing>()

        fun toData() : T? = if (this is Success) data else null

}

