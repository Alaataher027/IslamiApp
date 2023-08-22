package com.example.islamiapp.ui.chapterDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemVerseBinding

class versesAdapter(val verses:List<String>)
    : RecyclerView.Adapter<versesAdapter.ViewHolder>(){

    class ViewHolder(val binding: ItemVerseBinding)
        : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemVerseBinding
            .inflate(LayoutInflater.from(parent.context),
                parent, false
            )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = verses.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.content.text=
            verses[position]
    }
}