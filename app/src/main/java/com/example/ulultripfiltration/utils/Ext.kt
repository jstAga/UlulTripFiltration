package com.example.ulultripfiltration.utils

import com.example.ulultripfiltration.data.model.FilterModel

fun FilterModel.changeFilter(newFilter :FilterModel){
    this.category = newFilter.category
    this.region = newFilter.region
    this.guide = newFilter.guide
    this.date_departure = newFilter.date_departure
    this.date_arrival = newFilter.date_arrival
    this.complexity = newFilter.complexity
    this.duration = newFilter.duration
    this.price_min = newFilter.price_min
    this.price_max = newFilter.price_max
}