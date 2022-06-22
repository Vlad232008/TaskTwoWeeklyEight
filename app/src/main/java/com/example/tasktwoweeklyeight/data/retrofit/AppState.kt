package com.example.tasktwoweeklyeight.data.retrofit

import com.example.tasktwoweeklyeight.data.model.HeroModel

sealed class AppState {
    data class Success(val dataModel: List<HeroModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
}