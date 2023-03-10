package com.example.ulultripfiltration.ui.fragments.search

import android.util.Log
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.R
import com.example.ulultripfiltration.core.ui.base.BaseFragment
import com.example.ulultripfiltration.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>(R.layout.fragment_search) {

    override val binding by viewBinding(FragmentSearchBinding::bind)
    override val viewModel by viewModels<SearchViewModel>()
    private val filter by lazy { FilterModel() }

    override fun constructListeners() {
        super.constructListeners()

        setCategory()
        setDeparture()
        setComplexity()
        setDuration()
        setPrice()
        clear()
        showLog()
        search()
    }

    private fun clear() {
        binding.btnClear.setOnClickListener {
            with(filter){
                category = ""
                date_departure = ""
                complexity = ""
                duration = ""
                price_max = ""
            }
        }
    }

    private fun search() {
        binding.btnSearch.setOnClickListener {
            findNavController().navigate(R.id.toursFragment, bundleOf(KEY_FILTER to filter))
        }
    }

    private fun showLog() {
        binding.btnLog.setOnClickListener {
            Log.e("aga", "filter: $filter")
        }
    }

    private fun setPrice() {
        with(binding) {
            etMaxPrice.doAfterTextChanged {
                filter.price_max= it.toString()
            }
        }
    }

    private fun setDuration() {
        with(binding) {
            btnOneDay.setOnClickListener {
                filter.duration = "1"
            }
            btnThreeDay.setOnClickListener {
                filter.duration = "3"
            }
            btnSevenDay.setOnClickListener {
                filter.duration = "7"
            }
        }
    }

    private fun setComplexity() {
        with(binding) {
            btnEasy.setOnClickListener {
                filter.complexity = "Easy"
            }
            btnMedium.setOnClickListener {
                filter.complexity = "Medium"
            }
            btnHard.setOnClickListener {
                filter.complexity = "Hard"
            }
            btnExtra.setOnClickListener {
                filter.complexity = "Extra"
            }
        }
    }

    private fun setDeparture() {
        binding.etDeparture.doAfterTextChanged {
            filter.date_departure = it.toString()
        }
    }

    private fun setCategory() {
        binding.etCategory.doAfterTextChanged {
            filter.category = it.toString()
        }
    }

    companion object {
        const val KEY_FILTER = "key.filter"
    }
}