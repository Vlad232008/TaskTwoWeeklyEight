package com.example.tasktwoweeklyeight.cicerone

import com.example.tasktwoweeklyeight.data.model.Movie
import com.example.tasktwoweeklyeight.fragment.DetailsFragment
import com.example.tasktwoweeklyeight.fragment.FragmentProgram
import com.example.tasktwoweeklyeight.fragment.MainFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class MainScreen : ListCicerone {

    override fun showMainScreen() = FragmentScreen {
        MainFragment()
    }

    override fun showDetailsScreen(movie: Movie) = FragmentScreen {
        DetailsFragment.newInstance(movie)
    }

    override fun showFragmentProgram() = FragmentScreen {
        FragmentProgram()
    }
}