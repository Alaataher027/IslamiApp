package com.example.islamiapp.ui.main.tabs.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemChapterNameBinding

class ChapterNameRecyclerAdapter(private val names:List<String>):RecyclerView.Adapter<ChapterNameRecyclerAdapter.ViewHolder>() {



    class ViewHolder(val viewBinding: ItemChapterNameBinding)
        :RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemChapterNameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text=names[position]
        if(onItemClickListener!= null){
            holder.viewBinding.root
                .setOnClickListener{
                    onItemClickListener?.onItemClick(position,names[position])
                }
        }
    }

    var onItemClickListener:OnItemClickListener? = null

    fun interface OnItemClickListener{
        fun onItemClick(position: Int, names:String)
    }


}