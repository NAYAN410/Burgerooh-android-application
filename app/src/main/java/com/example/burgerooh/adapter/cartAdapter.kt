package com.example.burgerooh.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.burgerooh.databinding.CartItemBinding

class cartAdapter (private val cartItems: MutableList<String>, private val CartItemPrice: MutableList<String>,private val CartImage: MutableList<Int>) : RecyclerView.Adapter<cartAdapter.CartViewHolder>() {

private val itemQuantities = IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding= CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)
    }



    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = cartItems.size
   inner class CartViewHolder(private val binding: CartItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantities[position]
                cartFoodName.text = cartItems[position]
                cartItemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                cartItemQuantity.text = quantity.toString()

                minusbutton.setOnClickListener{
                    decreaseQuantity(position)
                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)
                }
                deletebutton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION) {
                        deleteItem(position)
                    }


                }





            }
        }

       private fun increaseQuantity(position: Int){
           if(itemQuantities[position]<10){
               itemQuantities[position]++
               notifyItemChanged(position)
           }
       }

        private fun  decreaseQuantity(position: Int){
            if (itemQuantities[position] > 1) {
                itemQuantities[position]--
                notifyItemChanged(position)
            }
        }


       private fun deleteItem(position: Int){
           cartItems.removeAt(position)
           CartItemPrice.removeAt(position)
           CartImage.removeAt(position)
           notifyItemRemoved(position)
           notifyItemRangeChanged(position,cartItems.size)
       }
    }
}