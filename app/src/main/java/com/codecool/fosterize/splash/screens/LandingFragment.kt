package com.codecool.fosterize.splash.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.codecool.fosterize.R

class LandingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

      //  findNavController().navigate(R.id.action_splashScreenContainerFragment_to_registrationFragment)
        return inflater.inflate(R.layout.fragment_landing, container, false)
    }

}