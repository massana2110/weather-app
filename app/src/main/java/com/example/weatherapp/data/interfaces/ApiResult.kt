package com.example.weatherapp.data.interfaces

interface ApiResult {
    fun onStarted()
    fun onSuccess(data: Any)
    fun onFailure(message: String)
}