package com.example.ulultripfiltration.ui.fragments.tours

import androidx.paging.PagingData
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.core.ui.base.BaseViewModel
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.data.repositories.ToursRepository
import com.example.ulultripfiltration.utils.changeFilter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ToursViewModel @Inject constructor(private val repository: ToursRepository) : BaseViewModel() {

    private var filter = FilterModel()
    var getPagingTour = getTours()

    fun setFilter(newFilter: FilterModel) = filter.changeFilter(newFilter)
    fun getTours(): Flow<PagingData<TourModel>> = repository.getTours(filter).gatherPagingRequest { it }
}