package com.example.madlevel2task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task1.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

private val places = arrayListOf<Place>()
private val placeAdapter = PlaceAdapter(places)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    fun initViews() {
        //TODO In initViews set the layout manager (StaggeredGridLayoutManager) and adapter of the RecyclerView.
        binding.rvPlaces.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        binding.rvPlaces.adapter =
            placeAdapter

        for (i in Place.PLACE_NAMES.indices) {
            places.add(Place(Place.PLACE_NAMES[i],        Place.PLACE_RES_DRAWABLE_IDS[i]))

        }
        placeAdapter.notifyDataSetChanged()
    }
}