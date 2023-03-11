package com.example.ulultripfiltration.data.repositories

import com.example.ulultripfiltration.core.network.paging.BaseRepository
import com.example.ulultripfiltration.core.network.result.Resource
import com.example.ulultripfiltration.data.RemoteDataSource
import com.example.ulultripfiltration.data.model.TourModelBySlug
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailRepository @Inject constructor(private val dataSource: RemoteDataSource) : BaseRepository() {

//    fun getTourBySlug(slug: String) = doRequest { dataSource.getTourBySlug(slug) }

//    fun getTourBySlug(slug: String): Flow<Resource<TourModel>> = flow {
//
//        emit(Resource.Loading())
//        try {
//            val data = dataSource.getTourBySlug(slug)
//        }
//        emit(Resource.Success(data))
//
//    }


    fun getTourBySlug(slug: String): Flow<Resource<TourModelBySlug>> = flow {
        emit(Resource.Loading())
        try {
            val data = dataSource.getTourModelBySlug(slug)
            emit(data)
        } catch (ioException: Exception) {
            emit(Resource.Error(ioException.localizedMessage ?: "Не известная ошибка"))
        }
    }
}
