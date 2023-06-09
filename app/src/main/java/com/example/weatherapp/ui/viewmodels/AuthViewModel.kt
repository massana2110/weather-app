package com.example.weatherapp.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.weatherapp.data.interfaces.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel

// @HiltViewModel
class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var listener: ApiResult? = null

    fun login() {
        // validate form inputs
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            listener?.onFailure("No leave empty from inputs")
            return
        }

        // TODO: login action

        listener?.onSuccess(true)
    }
}