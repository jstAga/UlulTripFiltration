package com.example.ulultripfiltration.data

import com.example.ulultripfiltration.core.network.BaseDataSource
import com.example.ulultripfiltration.data.remote.apiservice.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) : BaseDataSource() {

    suspend fun getSlugs() = getResult { apiService.getSlugs() }
    suspend fun getTourModelBySlug(slug: String) = getResult { apiService.getTourBySlug(slug) }

}