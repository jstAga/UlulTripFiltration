package com.example.ulultripfiltration.ui.fragments.tours

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.R
import com.example.ulultripfiltration.core.ui.base.BaseFragment
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.databinding.FragmentToursBinding
import com.example.ulultripfiltration.ui.fragments.search.SearchFragment.Companion.KEY_FILTER
import com.example.ulultripfiltration.ui.fragments.tours.adapter.ToursAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToursFragment : BaseFragment<FragmentToursBinding, ToursViewModel>(R.layout.fragment_tours) {

    override val binding by viewBinding(FragmentToursBinding::bind)
    override val viewModel by viewModels<ToursViewModel>()
    private val filter by lazy { arguments?.getSerializable(KEY_FILTER) as FilterModel }
    private val adapter by lazy { ToursAdapter(this::onItemClick) }

    override fun initialize() {
        super.initialize()
        initAdapter()
    }

    private fun initAdapter() {
        binding.rvTours.adapter = adapter
    }

    override fun initRequest() {
        super.initRequest()
        getTours()
    }

    override fun initSubscribers() {
        super.initSubscribers()
        collectTours()
    }

    private fun collectTours() {
        viewModel.getPagingTour.spectatePaging { adapter.submitData(it) }
    }

    private fun getTours() {
        viewModel.setFilter(filter)
        viewModel.getTours()
    }

    private fun onItemClick(model: TourModel) {
        model.guide.photo = "photo" // add photo into database
        findNavController().navigate(R.id.detailFragment, bundleOf(KEY_DETAIL_TOUR to model))
    }

    companion object {
        const val KEY_DETAIL_TOUR = "key.detail.tour"
    }
}