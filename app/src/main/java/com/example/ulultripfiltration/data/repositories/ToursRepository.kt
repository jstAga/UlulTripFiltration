package com.example.ulultripfiltration.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.data.remote.apiservice.ApiService
import com.example.ulultripfiltration.data.remote.pagingSources.ToursPagingSource
import javax.inject.Inject

class ToursRepository @Inject constructor(private val apiService: ApiService) {

    fun getTours(filter: FilterModel) = Pager(
        pagingSourceFactory = { ToursPagingSource(apiService = apiService, filter) },
        config = PagingConfig(pageSize = 10)
    ).flow
}