package com.example.ulultripfiltration.data.remote.apiservice

import com.example.ulultripfiltration.data.model.SlugResponse
import com.example.ulultripfiltration.data.model.TourModelBySlug
import com.example.ulultripfiltration.data.model.ToursResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("home/slugs")
    suspend fun getSlugs(): Response<SlugResponse>

    @GET("home/tours/")
    suspend fun getTours(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 1,
        @Query("category") category: String,
        @Query("date_departure") date_departure: String,
        @Query("complexity") complexity: String,
        @Query("duration") duration: String,
        @Query("price_max") price_max: String,
    ): Response<ToursResponse>

    @GET("home/tours/{slug}")
    suspend fun getTourBySlug(
        @Path("slug") slug: String,
    ): Response<TourModelBySlug>
}