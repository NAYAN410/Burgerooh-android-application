package com.example.burgerooh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgerooh.databinding.PoplarItemBinding

class PopularAdapter (private val Items: List<String>,private val price:List<String>,private val image:List<Int>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PoplarItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = Items[position]
        val images = image[position]
        val price = price[position]
        holder.bind(item,price,images)
    }
    override fun getItemCount(): Int {
        return Items.size
    }

    class PopularViewHolder (private val binding: PoplarItemBinding) :  RecyclerView.ViewHolder(binding.root){

        private val imagesView = binding.imageView9
        fun bind(item: String,price: String ,images: Int) {
            binding.foodNamePopular.text = item
            binding.PricePopular.text = price
            imagesView.setImageResource(images)
        }

    }
}