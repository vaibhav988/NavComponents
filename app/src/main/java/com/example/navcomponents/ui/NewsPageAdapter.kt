package com.example.navcomponents.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.navcomponents.R
import com.example.navcomponents.data.Articles
import com.example.navcomponents.databinding.ItemlayoutBinding

class NewsPageAdapter(val context: Context ,  navcontroller : NavController) : ListAdapter< Articles , NewsPageAdapter.ItemViewholder>(
    DiffCallback()
) {
    val navController = navcontroller

    lateinit var binding : ItemlayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewholder {
        binding  =  ItemlayoutBinding.inflate(LayoutInflater.from(context) , parent , false )
        return  ItemViewholder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewholder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
        val bundle  = Bundle()
        bundle.putSerializable("news" , getItem(position))

             holder.itemView.setOnClickListener(
             {
                 navController.navigate(R.id.action_listFragment_to_detailFragment , bundle)

             }
        )
    }

    class ItemViewholder(val binding: ItemlayoutBinding) : RecyclerView.ViewHolder(binding.root) {

         fun bind(item: Articles){
               binding.news = item
         }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Articles>() {
    override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem.source?.id == newItem.source?.id
    }

    override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
        return oldItem == newItem
    }
}
