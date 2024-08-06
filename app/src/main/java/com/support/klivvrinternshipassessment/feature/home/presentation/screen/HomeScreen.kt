package com.support.klivvrinternshipassessment.feature.home.presentation.screen

import android.content.Context
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.support.klivvrinternshipassessment.core.data.CityModel
import com.support.klivvrinternshipassessment.core.data.Coord
import com.support.klivvrinternshipassessment.core.helper.parseJsonToList
import com.support.klivvrinternshipassessment.core.utils.mergeSort
import com.support.klivvrinternshipassessment.feature.home.presentation.widgets.CityCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(context: Context, onCityClicked: (Coord) -> Unit) {
    val sortedCities = getSortedCities(context)


    LazyColumn {
        item {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 50.dp,
                        start = 10.dp,
                        end = 10.dp,
                    ),
                label = { Text(text = "Search") },
                placeholder = { Text(text = "Example: Sydney") },
                value = "", onValueChange = {})
        }
        items(sortedCities) {
            CityCard(city = it, onCityClicked = onCityClicked)
        }
    }


}

private fun getSortedCities(context: Context): List<CityModel> {
    val jsonInputStream = context.assets.open("cities[486].json")
    val parsedList = parseJsonToList(jsonInputStream)
    return mergeSort(parsedList)
}
