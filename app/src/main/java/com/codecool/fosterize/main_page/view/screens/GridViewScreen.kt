package com.codecool.fosterize.main_page.view.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codecool.fosterize.R
import com.codecool.fosterize.main_page.AutoFitGridRecycler
import com.codecool.fosterize.main_page.model.Doggo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_grid_view_screen.*
import kotlinx.android.synthetic.main.item_grid_view_screen.view.*

class GridViewScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grid_view_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfDoggos = listOf(
            Doggo("id", "Kaki", 5, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Pisi", 8, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Lajos", 5, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "István", 9, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Herold", 7, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Klára", 87, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Béla", 11, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Irén", 6, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Hedvig", 2, 1, 1, 1, true, true, "asd", true),
            Doggo("id", "Olajos", 3, 1, 1, 1, true, true, "asd", true),
        )
        grid_recycler.adapter = GridViewScreenAdapter(listOfDoggos, layoutInflater)
        grid_recycler.layoutManager = AutoFitGridRecycler(requireContext())
        Log.d("GridViewScreen", "Attached the adapter")
    }
}

private class GridViewScreenAdapter(
    val listOfDoggos: List<Doggo>,
    val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<GridViewScreenAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initDoggo(listOfDoggos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.item_grid_view_screen, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listOfDoggos.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun initDoggo(doggo: Doggo) {
            Picasso.get().load("https://wallpaperaccess.com/full/1101027.jpg")
                .into(view.doggo_iv)
            view.name_tv.text = "${doggo.name} (${doggo.age})"
            Log.d("GridViewScreenAdapter", "${doggo.name}")
            view.blurView.setBlurRadius(10.0f);
            view.blurView.setOverlayColor(R.color.black);
        }
    }
}