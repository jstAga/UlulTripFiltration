package com.example.ulultripfiltration.data.remote.pagingSources

import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.data.model.ToursResponse
import com.example.ulultripfiltration.core.network.paging.BasePagingSource
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.data.remote.apiservice.ApiService

class ToursPagingSource(private val apiService: ApiService, filter: FilterModel) :
    BasePagingSource<ToursResponse, TourModel>({
        apiService.getTours(
            it,
            category = filter.category,
            date_departure = filter.date_departure,
            complexity = filter.complexity,
            duration = filter.duration,
            price_max = filter.price_max,
        )
    })