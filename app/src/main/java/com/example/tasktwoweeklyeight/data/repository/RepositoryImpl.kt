package com.example.tasktwoweeklyeight.data.repository

import com.example.tasktwoweeklyeight.data.DataSource
import com.example.tasktwoweeklyeight.data.model.HeroModel
import com.example.tasktwoweeklyeight.data.retrofit.RetrofitFactory

class RepositoryImpl(
    private val dataSource: DataSource<List<HeroModel>> = RetrofitFactory()
) : Repository<List<HeroModel>> {
    override suspend fun getData(): List<HeroModel> {
        return dataSource.getData()
    }
}