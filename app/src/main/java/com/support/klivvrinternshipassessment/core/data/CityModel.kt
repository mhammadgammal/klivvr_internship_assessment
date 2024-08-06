package com.support.klivvrinternshipassessment.core.data

data class CityModel(
    val country: String,
    val name: String,
    val id: Int,
    val coord: Coord
)

data class Coord(
    val lon: Double,
    val lat: Double
)
