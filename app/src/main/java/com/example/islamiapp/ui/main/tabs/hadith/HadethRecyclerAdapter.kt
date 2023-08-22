package com.example.islamiapp.ui.main.tabs.hadith

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.databinding.ItemChapterNameBinding
import com.example.islamiapp.databinding.ItemHadethNameBinding
import com.example.islamiapp.ui.model.Hadeth

class HadethRecyclerAdapter(private var items:List<Hadeth>?):RecyclerView.Adapter<HadethRecyclerAdapter.ViewHolder>() {



    class ViewHolder(val viewBinding: ItemHadethNameBinding)
        :RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemHadethNameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return items?.size?:0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewBinding.title.text=items!![position].title
        if(onItemClickListener!= null){
            holder.viewBinding.root
                .setOnClickListener{
                    onItemClickListener?.onItemClick(position,items!![position])
                }
        }
    }

    var onItemClickListener:OnItemClickListener? = null

    fun bindItems(newList:List<Hadeth>){
        items = newList
        notifyDataSetChanged()

    }

//    fun insertItem(hadeth: Hadeth ){
//        items?.add(hadeth)
//        notifyItemInserted((items?.size-1)?:0)
//
//    }

    fun interface OnItemClickListener{
        fun onItemClick(position: Int, item:Hadeth)
    }


}