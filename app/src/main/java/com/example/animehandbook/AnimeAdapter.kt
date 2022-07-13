package com.example.animehandbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animehandbook.databinding.AnimeItemBinding

class AnimeAdapter: RecyclerView.Adapter<AnimeAdapter.AnimeHolder>() {
    val animeList = ArrayList<Anime>()
    class AnimeHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = AnimeItemBinding.bind(item)
        fun bind(anime: Anime) = with(binding){
            im.setImageResource(anime.imageId)
            tvTitle.text = anime.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_item, parent, false)
        return AnimeHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int {
        return animeList.size
    }

    fun addAnime(anime: Anime){
        animeList.add(anime)
        notifyDataSetChanged()
    }
}