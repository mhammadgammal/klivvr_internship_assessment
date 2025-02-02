package com.support.klivvrinternshipassessment.feature.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.support.klivvrinternshipassessment.core.data.CityModel
import com.support.klivvrinternshipassessment.feature.home.data.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repo: HomeRepository,
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    var searchQuery = _searchQuery.asStateFlow()
    private val _cities = MutableStateFlow<List<CityModel>>(emptyList())
    val cities = _cities.asStateFlow()

    init {
        _cities.value = repo.getSortedCities()
        loadCities()
    }

    fun onSearch(query: String) {
        _searchQuery.value = query
        _cities.value = repo.searchCities(query)
    }

    private fun loadCities() = viewModelScope.launch(Dispatchers.IO) {
        repo.loadCities()
    }
}
