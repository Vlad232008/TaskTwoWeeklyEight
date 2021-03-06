package com.example.tasktwoweeklyeight.data.retrofit

import com.example.tasktwoweeklyeight.data.model.Movie
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("api/all.json")
    fun getDataHeroAsync(): Deferred<List<Movie>>
}