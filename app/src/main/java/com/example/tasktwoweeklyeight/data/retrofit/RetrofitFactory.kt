package com.example.tasktwoweeklyeight.data.retrofit

import com.example.tasktwoweeklyeight.data.DataSource
import com.example.tasktwoweeklyeight.data.model.Movie
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory : DataSource<List<Movie>> {

    override suspend fun getData(): List<Movie> {
        return getService().getDataHeroAsync().await()
    }

    private fun getService(): ApiService {
        return createRetrofit().create(ApiService::class.java)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/"
    }
}