package com.example.ulultripfiltration.ui.fragments.tours

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.R
import com.example.ulultripfiltration.core.ui.base.BaseFragment
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.databinding.FragmentToursBinding
import com.example.ulultripfiltration.ui.fragments.search.SearchFragment.Companion.KEY_FILTER
import com.example.ulultripfiltration.ui.fragments.tours.adapter.ToursAdapter
import com.project.ulul.ui.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

    override fun establishRequest() {
        super.establishRequest()
        getTours()
    }

    override fun launchObservers() {
        super.launchObservers()
        collectTours()
    }

    private fun collectTours() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getToursState.collectLatest { state ->
                    when (state) {
                        is UIState.Error -> {}
                        is UIState.Idle -> {}
                        is UIState.Loading -> {}
                        is UIState.Success -> adapter.submitData(state.data)
                    }
                }
            }
        }
    }

    private fun getTours() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getTours(filter)
            }
        }
    }

    private fun onItemClick(model: TourModel) {
        model.guide.photo= "photo" // add photo into database
        findNavController().navigate(R.id.detailFragment , bundleOf(KEY_DETAIL_TOUR to model))
    }

    companion object {
        const val KEY_DETAIL_TOUR = "key.detail.tour"
    }
}