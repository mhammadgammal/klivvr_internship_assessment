package com.support.klivvrinternshipassessment.feature.home.presentation.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.support.klivvrinternshipassessment.core.data.CityModel
import com.support.klivvrinternshipassessment.core.data.Coord

@Composable
fun CityCard(city: CityModel, onCityClicked: (Coord) -> Unit) {
    Card(
        onClick = { onCityClicked(city.coord) },
        modifier = Modifier
            .padding(
                top = 50.dp,
                start = 10.dp,
                end = 10.dp
            )
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    horizontal = 10.dp,
                    vertical = 5.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "${city.name}, ${city.country}", fontSize = 25.sp)
            Box(modifier = Modifier.height(15.dp))
            Text(text = "${city.coord.lat}, ${city.coord.lon}", fontSize = 20.sp)
        }
    }
}
