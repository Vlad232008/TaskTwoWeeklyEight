package com.example.tasktwoweeklyeight.ui.cicerone

import com.example.tasktwoweeklyeight.data.model.HeroModel
import com.github.terrakok.cicerone.Screen

interface Listener {
    fun showMainScreen(): Screen
    fun showDetailsScreen(heroModel: HeroModel): Screen
    fun showFragmentProgram(): Screen
}