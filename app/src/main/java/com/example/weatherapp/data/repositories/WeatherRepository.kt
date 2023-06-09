package com.example.weatherapp.data.repositories

import com.example.weatherapp.data.network.api.SafeRequest
import com.example.weatherapp.data.network.api.WeatherApiClient
import com.example.weatherapp.data.network.api.WeatherApiResponses
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiClient: WeatherApiClient) :
    SafeRequest() {

    suspend fun getWeather(
        location: String,
        timesteps: String,
        units: String
    ): WeatherApiResponses {
        return apiRequest {
            apiClient.getWeatherForecast(location, timesteps, units)
        }
    }
}