package com.example.marvelapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.adapter.RecyclerViewAdapter
import com.example.marvelapp.data.DataSource
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.model.Superheroe

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var miRecyler: RecyclerView
    lateinit var miRecylerHorizontal: RecyclerView
    val miAdapter: RecyclerViewAdapter = RecyclerViewAdapter()
    val miAdapterHorizontal: RecyclerViewAdapter = RecyclerViewAdapter(true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarRecyclerVertical()
        cargarRecyclerHorizontal()
    }
    fun cargarRecyclerVertical(){
      miRecyler = binding.rvSuperHeroes
      miRecyler.setHasFixedSize(true)
      miRecyler.layoutManager = LinearLayoutManager(this)
      miAdapter.RecyclerViewAdapter(
          DataSource().getSuperHeroes(), this)
      miRecyler.adapter = miAdapter
    }

    fun cargarRecyclerHorizontal() {
        miRecylerHorizontal = binding.rvSuperHeroesHorizontal
        miRecylerHorizontal.setHasFixedSize(true)
        miRecylerHorizontal.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        miAdapterHorizontal.RecyclerViewAdapter(DataSource().getSuperHeroes(), this)
        miRecylerHorizontal.adapter = miAdapterHorizontal
    }

}