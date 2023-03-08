package com.example.ulultripfiltration.ui.fragments.detail

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ulultripfiltration.R
import com.example.ulultripfiltration.core.ui.base.BaseFragment
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.databinding.FragmentDetailBinding
import com.example.ulultripfiltration.ui.fragments.tours.ToursFragment.Companion.KEY_DETAIL_TOUR
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail){
    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel by viewModels<DetailViewModel>()
    private val model by lazy { arguments?.getSerializable(KEY_DETAIL_TOUR) as TourModel }
//    private val adapter by lazy { ReviewAdapter() }

    override fun initialize() {
        super.initialize()
//        binding.rvReview.adapter =
    }

    override fun assembleViews() {
        super.assembleViews()
        with(binding){
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
            tvDescription.text = model.description
        }
    }
}