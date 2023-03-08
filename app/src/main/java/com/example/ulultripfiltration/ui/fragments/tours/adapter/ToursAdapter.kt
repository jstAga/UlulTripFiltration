package com.example.ulultripfiltration.ui.fragments.tours.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.databinding.ItemTourBinding

class ToursAdapter(val onItemClick: (TourModel) -> Unit) :
    PagingDataAdapter<TourModel, ToursAdapter.TourModelPagingViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: TourModelPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourModelPagingViewHolder {
        return TourModelPagingViewHolder(
            ItemTourBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    inner class TourModelPagingViewHolder(
        private val binding: ItemTourBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: TourModel) {
            with(binding) {
                tvId.text = model.id.toString()
                tvTitle.text = model.title
                tvDuration.text = model.duration
                tvComplexity.text = model.complexity
                tvPrice.text = model.price.toString()
                tvGuide.text = model.guide.get_initials
                tvCategory.text = model.category.name
                tvRegion.text = model.region[0].name // TO DO show all regions
                tvDeparture.text = model.date_departure
                tvArrival.text = model.date_arrival

                itemView.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<TourModel>() {
            override fun areItemsTheSame(oldItem: TourModel, newItem: TourModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TourModel, newItem: TourModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}