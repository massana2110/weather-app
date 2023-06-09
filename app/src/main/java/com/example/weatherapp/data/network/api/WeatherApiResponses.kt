package com.example.weatherapp.data.network.api

import com.example.weatherapp.data.models.Locations
import com.example.weatherapp.data.models.Timeline

data class WeatherApiResponses(
    val timelines: Timeline,
    val location: Locations
)