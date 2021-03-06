package com.example.tasktwoweeklyeight.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tasktwoweeklyeight.R
import com.example.tasktwoweeklyeight.data.model.Movie
import com.example.tasktwoweeklyeight.databinding.FragmentDetailsBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment() {

    private var binding: FragmentDetailsBinding? = null
    private val bind get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding
            .inflate(inflater, container, false)

        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        renderData()
    }

    private fun renderData() {
        val data = arguments?.getParcelable<Movie>(KEY)

        with(bind) {
            data?.let {
                Picasso
                    .with(context)
                    .load(data.images.md)
                    .error(R.drawable.ic_baseline_error)
                    .into(bind.image)

                fullName.text = data.name
                intelligence.text = data.powerstats.intelligence.toString()
                strength.text = data.powerstats.strength.toString()
                speed.text = data.powerstats.speed.toString()
                durability.text = data.powerstats.durability.toString()
                power.text = data.powerstats.power.toString()
                combat.text = data.powerstats.combat.toString()

            }
        }
    }

    companion object {
        private const val KEY = "details"

        fun newInstance(data: Movie) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY, data)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}