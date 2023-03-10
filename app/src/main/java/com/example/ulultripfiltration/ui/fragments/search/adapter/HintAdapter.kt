package com.example.ulultripfiltration.ui.fragments.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ulultripfiltration.databinding.ItemHintBinding

class HintAdapter(private val onHintClick: (String) -> Unit) : Adapter<HintAdapter.HintViewHolder>() {

    private val data = arrayListOf<String>()

    fun addData(newData: List<String>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HintViewHolder {
        return HintViewHolder(ItemHintBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: HintViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class HintViewHolder(private val binding: ItemHintBinding) : ViewHolder(binding.root) {
        fun bind(hint: String) {
            binding.tvHint.text = hint

            itemView.setOnClickListener {
                onHintClick(hint)
            }
        }
    }
}