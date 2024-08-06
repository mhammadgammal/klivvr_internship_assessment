package com.support.klivvrinternshipassessment.feature.home.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.support.klivvrinternshipassessment.core.data.CityModel
import com.support.klivvrinternshipassessment.core.helper.parseJsonToList
import com.support.klivvrinternshipassessment.core.utils.BinarySearchTree
import com.support.klivvrinternshipassessment.core.utils.mergeSort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    context: Context
) : ViewModel() {
    private val jsonInputStream = context.assets.open("cities[486].json")
    private val parsedList = parseJsonToList(jsonInputStream)
    private val bst = BinarySearchTree()
    private val _searchQuery = MutableStateFlow("")
    var searchQuery = _searchQuery.asStateFlow()
    private val _cities = MutableStateFlow<List<CityModel>>(emptyList())
    val cities = _cities.asStateFlow()

    init {
        getSortedCities()
        loadCities()
    }

    private fun loadCities() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                parsedList.forEach {
                    bst.insert(it)
                }
            }
        }
    }

    fun onSearch(query: String) {
        _searchQuery.value = query
        if (query.isEmpty()) {
            getSortedCities()
        } else {
            search(query)
        }
    }

    private fun search(
        searchQuery: String
    ) {
        _cities.value = bst.search(searchQuery)
    }

    private fun getSortedCities() {
        _cities.value = mergeSort(parsedList)
    }
}
