package com.codecool.fosterize.main_page.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codecool.fosterize.R
import com.codecool.fosterize.main_page.presenter.MainFeedPresenter
import com.codecool.fosterize.main_page.presenter.MainFeedPresenterInterface
import com.codecool.fosterize.main_page.view.screens.GridViewScreen
import kotlinx.android.synthetic.main.fragment_main_page.*

class MainPageFragment : Fragment(), MainFeedPresenterInterface {

    lateinit var presenter : MainFeedPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainFeedPresenter(this)
        view_pager_mainmenu.adapter = MainMenuViewPagerAdapter(listOf(GridViewScreen()),parentFragmentManager,lifecycle)
    }
}

private class MainMenuViewPagerAdapter(val pages : List<Fragment>,fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int = pages.size
    override fun createFragment(position: Int): Fragment = pages[position]
}