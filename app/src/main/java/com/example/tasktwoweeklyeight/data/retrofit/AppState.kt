package com.example.tasktwoweeklyeight.data.retrofit

import com.example.tasktwoweeklyeight.data.model.Movie

sealed class AppState {
    data class Success(val dataModel: List<Movie>?) : AppState()
    data class Error(val error: Throwable) : AppState()
}