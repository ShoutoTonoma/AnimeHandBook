package com.example.animehandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animehandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = AnimeAdapter()
    private val imageIdList = listOf(
        R.drawable.anime1,
        R.drawable.anime2,
        R.drawable.anime3,
        R.drawable.anime4,
        R.drawable.anime5
    )
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if (index > 4) index = 0
                val anime = Anime(imageIdList[index], "Anime $index")
                adapter.addAnime(anime)
                index++
            }
        }
    }
}