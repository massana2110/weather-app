package com.example.weatherapp.ui.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.R
import com.example.weatherapp.data.interfaces.ApiResult
import com.example.weatherapp.data.models.DailyTimeline
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.ui.adapters.WeatherAdapter
import com.example.weatherapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherFragment : Fragment(), ApiResult {

    private lateinit var _binding: FragmentWeatherBinding
    private val weatherViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_weather,
            container,
            false
        )

        weatherViewModel.listener = this

        _binding.searchButton.setOnClickListener {
            weatherViewModel.getWeatherAction(_binding.locationEdittext.text.toString())
        }

        return _binding.root
    }


    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(data: Any) {
        _binding.weatherRecyclerView.also { rv ->
            rv.layoutManager = LinearLayoutManager(requireContext())
            rv.setHasFixedSize(true)
            rv.adapter = WeatherAdapter(data as List<DailyTimeline>)
        }
    }

    override fun onFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}