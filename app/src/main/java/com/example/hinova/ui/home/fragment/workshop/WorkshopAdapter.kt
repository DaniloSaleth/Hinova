package com.example.hinova.ui.home.fragment.workshop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hinova.databinding.WorkshopItemBinding
import com.example.hinova.model.Workshop

class WorkshopAdapter(private val workshops: List<Workshop>) : RecyclerView.Adapter<WorkshopAdapter.WorkshopViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkshopViewHolder {
        val binding = WorkshopItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkshopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WorkshopViewHolder, position: Int) {
        holder.bind(workshops[position])
    }

    override fun getItemCount(): Int = workshops.size

    class WorkshopViewHolder(private val binding: WorkshopItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(workshop: Workshop) {
            binding.workshopName.text = workshop.Nome
        }
    }
}