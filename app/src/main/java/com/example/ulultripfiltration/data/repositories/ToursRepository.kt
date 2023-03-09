package com.example.ulultripfiltration.data.repositories

import androidx.paging.PagingData
import com.example.ulultripfiltration.core.network.paging.BaseRepository
import com.example.ulultripfiltration.data.model.FilterModel
import com.example.ulultripfiltration.data.model.TourModel
import com.example.ulultripfiltration.data.remote.apiservice.ApiService
import com.example.ulultripfiltration.data.remote.pagingSources.ToursPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ToursRepository @Inject constructor(private val apiService: ApiService) : BaseRepository() {

    fun getTours(filter: FilterModel): Flow<PagingData<TourModel>> {
        return doPagingRequest(ToursPagingSource(apiService ,filter), pageSize = 10)}
}