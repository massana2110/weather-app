package com.example.weatherapp.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weatherapp.R
import com.example.weatherapp.data.interfaces.ApiResult
import com.example.weatherapp.databinding.FragmentLoginBinding
import com.example.weatherapp.ui.viewmodels.AuthViewModel

class LoginFragment : Fragment(), ApiResult {

    private lateinit var _binding : FragmentLoginBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        _binding.authViewModel = authViewModel
        authViewModel.listener = this

        _binding.loginButton.setOnClickListener {
            // TODO: Call login action
            authViewModel.login()
        }

        return _binding.root
    }

    override fun onStarted() {
        TODO("Not yet implemented")
    }

    override fun onSuccess(data: Any) {
        findNavController().navigate(R.id.action_loginFragment_to_weatherFragment)
    }

    override fun onFailure(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

}