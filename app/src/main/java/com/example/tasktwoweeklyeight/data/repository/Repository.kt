package com.example.tasktwoweeklyeight.data.repository

interface Repository<T> {
    suspend fun getData(): T
}