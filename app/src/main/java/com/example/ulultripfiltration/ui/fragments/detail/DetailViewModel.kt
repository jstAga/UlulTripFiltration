package com.example.ulultripfiltration.ui.fragments.detail

import com.example.ulultripfiltration.core.ui.base.BaseViewModel
import com.example.ulultripfiltration.data.model.TourModelBySlug
import com.example.ulultripfiltration.data.repositories.DetailRepository
import com.example.ulultripfiltration.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: DetailRepository) : BaseViewModel() {

    private val _getTourBySlugState = MutableStateFlow<UIState<TourModelBySlug>>(UIState.Idle())
    val getTourBySlugState = _getTourBySlugState.asStateFlow()

    fun getTourBySlug(slug : String) = repository.getTourBySlug(slug).collectFlow(_getTourBySlugState)
}