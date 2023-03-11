package com.example.ulultripfiltration.data.model

import com.example.ulultripfiltration.core.network.paging.DataMapper

data class ToursResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<TourModel>,
) : DataMapper<TourModel> {
    override fun responseToModel(): List<TourModel> = this.results
}

class TourModelBySlug : ArrayList<TourModel>()

data class TourModel(
    val average_rating: String,
    val category: CategoryModel,
    val complexity: String,
    val date_arrival: String,
    val date_departure: String?,
    val date_published: String,
    val description: String,
    val duration: String,
    val guide: Guide,
    val id: Int,
    val is_hot: Boolean,
    val price: Int,
    val quantity_limit: Int,
    val region: List<Region>,
    val set_actual_limit: Int,
    val slug: String,
    val title: String,
    val tour_images: List<TourImage>,
) : java.io.Serializable

data class Region(
    val id: Int,
    val name: String = "",
): java.io.Serializable

data class Guide(
    val get_initials: String,
    val id: Int,
    var photo: String =  "test",
): java.io.Serializable

data class TourImage(
    val images: String = "",
    val is_main: Boolean,
): java.io.Serializable