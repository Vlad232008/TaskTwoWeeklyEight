package com.example.tasktwoweeklyeight.util

import androidx.recyclerview.widget.DiffUtil
import com.example.tasktwoweeklyeight.data.model.Movie

class DiffUtilsCallBack(
    private val oldList: List<Movie>,
    private val newList: List<Movie>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == oldList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}