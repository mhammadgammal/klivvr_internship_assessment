package com.support.klivvrinternshipassessment.feature.home.data.repository

import android.content.Context
import com.support.klivvrinternshipassessment.core.data.CityModel
import com.support.klivvrinternshipassessment.core.helper.parseJsonToList
import com.support.klivvrinternshipassessment.core.utils.BinarySearchTree
import com.support.klivvrinternshipassessment.core.utils.mergeSort
import javax.inject.Inject

class HomeRepository @Inject constructor(context: Context) {
    private val jsonInputStream = context.assets.open("cities[486].json")
    private val parsedList = parseJsonToList(jsonInputStream)
    private val bst = BinarySearchTree()

    private fun search(searchQuery: String): List<CityModel> = bst.search(searchQuery)


    fun getSortedCities(): List<CityModel> = mergeSort(parsedList)

    fun loadCities() {
        parsedList.forEach {
            bst.insert(it)
        }
    }

    fun searchCities(query: String): List<CityModel> = if (query.isEmpty()) {
        getSortedCities()
    } else {
        search(query)
    }


}
