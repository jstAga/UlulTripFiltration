package com.example.ulultripfiltration.ui.fragments.search

import com.example.ulultripfiltration.core.ui.base.BaseViewModel
import com.example.ulultripfiltration.data.model.SlugResponse
import com.example.ulultripfiltration.data.repositories.SearchRepository
import com.example.ulultripfiltration.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: SearchRepository): BaseViewModel() {

    private val _getSlugsState = MutableStateFlow<UIState<SlugResponse>>(UIState.Idle())
    val getSlugsState = _getSlugsState.asStateFlow()

    fun getSlugs() = repository.getSlugs().collectFlow(_getSlugsState)

}