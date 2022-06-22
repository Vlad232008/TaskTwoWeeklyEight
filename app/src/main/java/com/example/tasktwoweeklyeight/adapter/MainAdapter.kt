package com.example.tasktwoweeklyeight.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tasktwoweeklyeight.R
import com.example.tasktwoweeklyeight.data.model.Movie
import com.example.tasktwoweeklyeight.util.DiffUtilsCallBack
import com.squareup.picasso.Picasso

class MainAdapter(
    private val onListItemClickListener: ItemClickListener,
    private var data: ArrayList<Movie> = arrayListOf()
) : RecyclerView.Adapter<MainAdapter.RecyclerItemViewHolder>() {

    fun setData(newData: List<Movie>) {
        val diffUtilsCallBack = DiffUtilsCallBack(data, newData)
        val diffResult = DiffUtil.calculateDiff(diffUtilsCallBack)
        data.addAll(newData)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemViewHolder {
        return RecyclerItemViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.hero_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: RecyclerItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class RecyclerItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(data: Movie) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                itemView.findViewById<TextView>(R.id.name).text = data.name

                Picasso.with(itemView.context)
                    .load(data.images.md)
                    .error(R.drawable.ic_baseline_error)
                    .into(itemView.findViewById<ImageView>(R.id.image))

                itemView.setOnClickListener { openInNewWindow(data) }
            }
        }

        private fun openInNewWindow(dataModel: Movie) {
            onListItemClickListener.onItemClick(dataModel)
        }
    }

    interface ItemClickListener {
        fun onItemClick(dataModel: Movie)
    }
}