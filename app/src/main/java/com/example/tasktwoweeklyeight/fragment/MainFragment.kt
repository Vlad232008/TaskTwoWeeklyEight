package com.example.tasktwoweeklyeight.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tasktwoweeklyeight.MainApplication.Companion.router
import com.example.tasktwoweeklyeight.data.model.Movie
import com.example.tasktwoweeklyeight.data.retrofit.AppState
import com.example.tasktwoweeklyeight.R
import com.example.tasktwoweeklyeight.databinding.FragmentMainBinding
import com.example.tasktwoweeklyeight.adapter.MainAdapter
import com.example.tasktwoweeklyeight.cicerone.MainScreen
import com.example.tasktwoweeklyeight.viewmodel.MainViewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val adapter: MainAdapter by lazy { MainAdapter(onListItemClickListener) }

    private val onListItemClickListener: MainAdapter.ItemClickListener =
        object : MainAdapter.ItemClickListener {
            override fun onItemClick(dataModel: Movie) {
                router.navigateTo(MainScreen().showDetailsScreen(dataModel))
            }
        }

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)
        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = GridLayoutManager(context,2)
        binding.recyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.toObserve.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getData()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {
                Toast.makeText(context, appState.error.message, Toast.LENGTH_SHORT).show()
                Log.d("MyLog", appState.error.message.toString())
            }
            is AppState.Success -> {
                appState.dataModel?.let {
                    if (it.isEmpty())
                        Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show()
                    else
                        adapter.setData(it)
                }
            }
        }
    }
}