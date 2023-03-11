package com.example.ulultripfiltration.ui.fragments.detail

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ulultripfiltration.R
import com.example.ulultripfiltration.core.ui.base.BaseFragment
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.databinding.FragmentDetailBinding
import com.example.ulultripfiltration.ui.fragments.search.SearchFragment.Companion.KEY_SlUG
import com.example.ulultripfiltration.ui.fragments.tours.ToursFragment.Companion.KEY_DETAIL_TOUR
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding, DetailViewModel>(R.layout.fragment_detail) {
    override val binding by viewBinding(FragmentDetailBinding::bind)
    override val viewModel by viewModels<DetailViewModel>()
    private var model: TourModel? = null

    override fun initialize() {
        super.initialize()
        getModel()
    }

    private fun getModel() {
        if (arguments?.getSerializable(KEY_SlUG) != null) {
            viewModel.getTourBySlug(arguments?.getSerializable(KEY_SlUG) as String)
            viewModel.getTourBySlugState.collectUIState {
                setData(it[0])
            }
        } else {
            model = arguments?.getSerializable(KEY_DETAIL_TOUR) as TourModel
            setData(model!!)
        }
    }

    private fun setData(data: TourModel) {
        with(binding) {
            tvId.text = data.id.toString()
            tvTitle.text = data.title
            tvDuration.text = data.duration
            tvComplexity.text = data.complexity
            tvPrice.text = data.price.toString()
            tvGuide.text = data.guide.get_initials
            tvCategory.text = data.category.name
            tvRegion.text = data.region.get(0).name    // TO DO show all regions
            tvDeparture.text = data.date_departure
            tvArrival.text = data.date_arrival
            tvDescription.text = data.description
        }
    }
}