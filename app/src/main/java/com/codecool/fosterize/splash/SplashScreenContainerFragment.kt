package com.codecool.fosterize.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codecool.fosterize.R
import com.codecool.fosterize.splash.screens.FinalLandingFragment
import com.codecool.fosterize.splash.screens.LandingFragment
import com.codecool.fosterize.splash.screens.SecondLandingFragment
import com.codecool.fosterize.splash.screens.ThirdLandingFragment
import kotlinx.android.synthetic.main.fragment_splash_screen_container.*

class SplashScreenContainerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_splash_screen_container, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragments = arrayListOf<Fragment>(
            LandingFragment(),
            SecondLandingFragment(),
            ThirdLandingFragment(),
            FinalLandingFragment()
        )
        val adapter = ViewPagerAdapter(fragments, parentFragmentManager, lifecycle)
        view_pager.adapter = adapter
    }
}