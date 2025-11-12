package com.kotlinmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kotlinmvvm.R
import com.kotlinmvvm.databinding.RowMuseumBinding
import com.kotlinmvvm.model.Museum


class MuseumAdapter(private var museums: List<Museum>) :
    RecyclerView.Adapter<MuseumAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MViewHolder {
        // Inflate the layout using DataBindingUtil
        val binding: RowMuseumBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_museum,
            parent,
            false
        )
        return MViewHolder(binding)
    }

    override fun onBindViewHolder(vh: MViewHolder, position: Int) {
        vh.bind(museums[position])
    }

    override fun getItemCount(): Int {
        return museums.size
    }

    fun update(data: List<Museum>) {
        museums = data
        notifyDataSetChanged()
    }

    class MViewHolder(private val binding: RowMuseumBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(museum: Museum) {
            binding.museum = museum
            binding.executePendingBindings()
        }
    }

}