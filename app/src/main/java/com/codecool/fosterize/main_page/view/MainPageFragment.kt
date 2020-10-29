package com.codecool.fosterize.main_page.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.codecool.fosterize.R
import com.codecool.fosterize.main_page.presenter.MainFeedPresenter
import com.codecool.fosterize.main_page.presenter.MainFeedPresenterInterface
import com.codecool.fosterize.main_page.view.screens.FullScreenFragment
import com.codecool.fosterize.main_page.view.screens.GridViewScreen
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_main_page.*
import kotlinx.android.synthetic.main.fragment_splash_screen_container.*

class MainPageFragment : Fragment(), MainFeedPresenterInterface {

    lateinit var presenter : MainFeedPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = MainFeedPresenter(this)

        context?.let{
            val listOfIcons = listOf(ContextCompat.getDrawable(it,R.drawable.ic_grid_icon), ContextCompat.getDrawable(it,R.drawable.ic_full_screen_icon))
            view_pager_mainmenu.adapter = MainMenuViewPagerAdapter(listOf(GridViewScreen(), FullScreenFragment()),parentFragmentManager,lifecycle)
            TabLayoutMediator(tab_layout,view_pager_mainmenu) { tab, position ->
                tab.icon = listOfIcons[position]
                view_pager_mainmenu.currentItem = tab.position
            }.attach()
        }
    }
}

private class MainMenuViewPagerAdapter(val pages : List<Fragment>,fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int = pages.size
    override fun createFragment(position: Int): Fragment = pages[position]
}