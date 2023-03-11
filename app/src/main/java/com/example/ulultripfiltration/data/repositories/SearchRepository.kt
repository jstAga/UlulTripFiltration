package com.example.ulultripfiltration.data.repositories

import com.example.ulultripfiltration.core.network.paging.BaseRepository
import com.example.ulultripfiltration.data.RemoteDataSource
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
) : BaseRepository() {

    fun getSlugs() = doRequest { dataSource.getSlugs() }
}
