package com.example.tasktwoweeklyeight.ui.cicerone

import com.example.tasktwoweeklyeight.data.model.HeroModel
import com.example.tasktwoweeklyeight.ui.fragment.DetailsFragment
import com.example.tasktwoweeklyeight.ui.fragment.FragmentProgram
import com.example.tasktwoweeklyeight.ui.fragment.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MainScreen : Listener {

    override fun showMainScreen() = FragmentScreen {
        MainFragment()
    }

    override fun showDetailsScreen(heroModel: HeroModel) = FragmentScreen {
        DetailsFragment.newInstance(heroModel)
    }

    override fun showFragmentProgram() = FragmentScreen {
        FragmentProgram()
    }
}