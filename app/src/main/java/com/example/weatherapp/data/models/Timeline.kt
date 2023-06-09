package com.example.weatherapp.data.models

data class Timeline(
    val daily: List<DailyTimeline>?
)

data class DailyTimeline(
    val time: String,
    val values: DailyValues
)

data class DailyValues(
    val humidityAvg: String,
    val precipitationProbabilityAvg: String,
    val temperatureAvg: String,
    val temperatureMax: String,
    val temperatureMin: String,
)