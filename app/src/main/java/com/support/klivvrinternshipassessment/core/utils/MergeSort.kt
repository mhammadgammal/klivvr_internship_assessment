package com.support.klivvrinternshipassessment.core.utils

import com.support.klivvrinternshipassessment.core.data.CityModel

fun mergeSort(cities: List<CityModel>): List<CityModel> {
    if (cities.size <= 1) return cities

    val middle = cities.size / 2
    val left = cities.subList(0, middle)
    val right = cities.subList(middle, cities.size)

    return merge(mergeSort(left), mergeSort(right))
}

private fun merge(left: List<CityModel>, right: List<CityModel>): List<CityModel> {
    var leftIndex = 0
    var rightIndex = 0
    val result = mutableListOf<CityModel>()

    while (leftIndex < left.size && rightIndex < right.size) {
        val leftCity = left[leftIndex]
        val rightCity = right[rightIndex]

        if (leftCity.name <= rightCity.name) {
            result.add(leftCity)
            leftIndex++
        } else {
            result.add(rightCity)
            rightIndex++
        }
    }

    result.addAll(left.subList(leftIndex, left.size))
    result.addAll(right.subList(rightIndex, right.size))

    return result
}
