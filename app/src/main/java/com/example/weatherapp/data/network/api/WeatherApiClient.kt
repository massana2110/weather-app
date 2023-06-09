package com.example.weatherapp.data.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "BLK5sN2uXDgRp4rdMS9x5mQi7rR26n7A"

interface WeatherApiClient {

    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("location") location: String,
        @Query("timesteps") timesteps: String,
        @Query("units") units: String,
        @Query("apikey") apiKey: String = API_KEY
    ) : Response<WeatherApiResponses>
}