package com.example.ulultripfiltration.core.network.paging

interface DataMapper<T> {
    fun responseToModel(): List<T>
}