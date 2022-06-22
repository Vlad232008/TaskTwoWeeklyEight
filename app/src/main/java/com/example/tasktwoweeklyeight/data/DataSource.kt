package com.example.tasktwoweeklyeight.data

interface DataSource<T> {
    suspend fun getData(): T
}