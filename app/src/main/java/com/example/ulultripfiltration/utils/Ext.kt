package com.example.ulultripfiltration.utils

import com.example.ulultripfiltration.data.model.FilterModel

fun FilterModel.changeFilter(newFilter :FilterModel){
    this.category = newFilter.category
    this.date_departure = newFilter.date_departure
    this.complexity = newFilter.complexity
    this.duration = newFilter.duration
    this.price_max = newFilter.price_max
}