package com.example.weatherapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.interfaces.ApiResult
import com.example.weatherapp.data.repositories.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    var listener: ApiResult? = null

    fun getWeatherAction(location: String) {
        viewModelScope.launch {
            try {
                val result = weatherRepository.getWeather(
                    location,
                    "1d",
                    "metric"
                )

                result.timelines.daily?.let {
                    listener?.onSuccess(it)
                    return@launch
                }

                listener?.onFailure("Fallo al intentar obtener informacion de clima")

            } catch (ex: Exception) {
                ex.message?.let { listener?.onFailure(it) }
            }
        }
    }

}