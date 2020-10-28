package com.codecool.fosterize.main_page.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.codecool.fosterize.R
import com.codecool.fosterize.main_page.presenter.MainFeedPresenter
import com.codecool.fosterize.main_page.presenter.MainFeedPresenterInterface

class MainPageFragment : Fragment(), MainFeedPresenterInterface {

    lateinit var presenter : MainFeedPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainFeedPresenter(this)
    }
}