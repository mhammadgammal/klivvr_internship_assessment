package com.support.klivvrinternshipassessment.core.helper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.support.klivvrinternshipassessment.core.data.CityModel
import java.io.InputStream
import java.io.InputStreamReader

fun parseJsonToList(jsonInputStream: InputStream): List<CityModel> {
    val gson = Gson()
    val jsonReader = InputStreamReader(jsonInputStream)
    val cityType = object : TypeToken<List<CityModel>>() {}.type
    val cities: List<CityModel> = gson.fromJson(jsonReader, cityType)
    return cities
}
