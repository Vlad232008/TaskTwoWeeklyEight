package com.example.tasktwoweeklyeight.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tasktwoweeklyeight.MainApp.Companion.router
import com.example.tasktwoweeklyeight.R
import com.example.tasktwoweeklyeight.databinding.FragmentProgramBinding

class FragmentProgram : Fragment(R.layout.fragment_program) {

    private lateinit var binding: FragmentProgramBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProgramBinding.bind(view)

        binding.accept.setOnClickListener {
            router.exit()
        }
    }
}