package com.example.tasktwoweeklyeight.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tasktwoweeklyeight.MainApp.Companion.router
import com.example.tasktwoweeklyeight.data.model.HeroModel
import com.example.tasktwoweeklyeight.data.retrofit.AppState
import com.example.tasktwoweeklyeight.R
import com.example.tasktwoweeklyeight.databinding.FragmentMainBinding
import com.example.tasktwoweeklyeight.ui.adapter.MainAdapter
import com.example.tasktwoweeklyeight.ui.cicerone.MainScreen
import com.example.tasktwoweeklyeight.ui.model.MainViewModel


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private val adapter: MainAdapter by lazy { MainAdapter(onListItemClickListener) }

    private val onListItemClickListener: MainAdapter.ItemClickListener =
        object : MainAdapter.ItemClickListener {
            override fun onItemClick(dataModel: HeroModel) {
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
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
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
                Log.d("MY_TAG", appState.error.message.toString())
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