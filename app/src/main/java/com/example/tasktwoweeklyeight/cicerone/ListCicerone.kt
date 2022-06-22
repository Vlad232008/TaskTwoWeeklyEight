package com.example.tasktwoweeklyeight.cicerone

import com.example.tasktwoweeklyeight.data.model.Movie
import com.github.terrakok.cicerone.Screen

interface ListCicerone {
    fun showMainScreen(): Screen
    fun showDetailsScreen(movie: Movie): Screen
    fun showFragmentProgram(): Screen
}