package com.example.tasktwoweeklyeight.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.tasktwoweeklyeight.MainApplication.Companion.navigatorHolder
import com.example.tasktwoweeklyeight.MainApplication.Companion.router
import com.example.tasktwoweeklyeight.R
import com.example.tasktwoweeklyeight.cicerone.MainScreen
import com.github.terrakok.cicerone.androidx.AppNavigator

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, R.id.container)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Второе задание восьмой недели"
        if (savedInstanceState == null)
            router.navigateTo(MainScreen().showMainScreen())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater
            .inflate(R.menu.menu_heroes, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.program -> {
                router.navigateTo(
                    MainScreen()
                        .showFragmentProgram()
                )
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager
                .backStackEntryCount == 0
        )
            finish()
    }
}