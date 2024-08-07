package com.support.klivvrinternshipassessment.feature.home.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.support.klivvrinternshipassessment.core.data.Coord
import com.support.klivvrinternshipassessment.feature.home.presentation.viewmodel.HomeViewModel
import com.support.klivvrinternshipassessment.feature.home.presentation.widgets.CityCard

@Composable
fun HomeScreen(onCityClicked: (Coord) -> Unit) {
    val vm = hiltViewModel<HomeViewModel>()
    val cities = vm.cities.collectAsState()
    val search = vm.searchQuery.collectAsState()
    Column {

        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 50.dp,
                start = 10.dp,
                end = 10.dp, bottom = 10.dp,
            ),
            label = { Text(text = "Search", fontSize = 20.sp) },
            placeholder = { Text(text = "Example: Sydney", fontSize = 20.sp) },
            value = search.value,
            textStyle = TextStyle(fontSize = 20.sp),
            leadingIcon = {
                Image(imageVector = Icons.Outlined.Search, contentDescription = "Search icon")
            },
            trailingIcon = {
                if (search.value.isNotEmpty()) {
                    Image(
                        modifier = Modifier
                            .clickable {
                                vm.onSearch("")
                            },
                        imageVector = Icons.Outlined.Close,
                        contentDescription = "Cancel icon to remove search query"
                    )
                }
            },
            onValueChange = {
                vm.onSearch(it)
            })

        LazyColumn {
            items(cities.value) {
                CityCard(city = it, onCityClicked = onCityClicked)
            }
        }
    }


}
