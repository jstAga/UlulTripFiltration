package com.example.ulultripfiltration.ui.fragments.tours

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.core.ui.base.BaseViewModel
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.data.repositories.ToursRepository
import com.project.ulul.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToursViewModel @Inject constructor(private val repository: ToursRepository) : BaseViewModel() {

    private val _getToursState = MutableStateFlow<UIState<PagingData<TourModel>>>(UIState.Idle())
    val getToursState = _getToursState.asStateFlow()

    fun getTours(filter: FilterModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getTours(filter).collect() {
                _getToursState.value = UIState.Success(it)
            }
        }
    }
}