package com.example.tasktwoweeklyeight.data.repository

import com.example.tasktwoweeklyeight.data.DataSource
import com.example.tasktwoweeklyeight.data.model.Movie
import com.example.tasktwoweeklyeight.data.retrofit.RetrofitFactory

class RepositoryImpl(
    private val dataSource: DataSource<List<Movie>> = RetrofitFactory()
) : Repository<List<Movie>> {
    override suspend fun getData(): List<Movie> {
        return dataSource.getData()
    }
}