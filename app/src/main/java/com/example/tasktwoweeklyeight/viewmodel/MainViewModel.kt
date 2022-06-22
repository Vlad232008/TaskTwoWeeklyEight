package com.example.tasktwoweeklyeight.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tasktwoweeklyeight.MainApplication
import com.example.tasktwoweeklyeight.data.model.Movie
import com.example.tasktwoweeklyeight.data.repository.Repository
import com.example.tasktwoweeklyeight.data.repository.RepositoryImpl
import com.example.tasktwoweeklyeight.data.retrofit.AppState
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val repository: Repository<List<Movie>> = RepositoryImpl()
) : ViewModel() {
    private val sharedPreferences =
        MainApplication.ContextHolder.context
            .getSharedPreferences(heroTag, Context.MODE_PRIVATE)

    private val data = MutableLiveData<AppState>()

    val toObserve: LiveData<AppState> = data

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val dataFromSharedPrefs = sharedPreferences.getString(dataTag, null)
                val gson = Gson()
                if (dataFromSharedPrefs != null) {
                    val dataFromPrefs = gson.fromJson(
                        dataFromSharedPrefs,
                        Array<Movie>::class.java
                    ).asList()

                    data.postValue(AppState.Success(dataFromPrefs))
                } else {
                    val data = repository.getData()
                    this@MainViewModel.data.postValue(AppState.Success(data))
                    val editor = sharedPreferences.edit()
                    editor.putString(dataTag, gson.toJson(data)).apply()
                }
            } catch (e: Throwable) {
                data.postValue(AppState.Error(e))
            }
        }
    }

    companion object {
        private const val heroTag = "movieHero"
        private const val dataTag = "data"
    }
}