package com.example.burgerooh.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.burgerooh.R
import com.example.burgerooh.adapter.cartAdapter
import com.example.burgerooh.databinding.FragmentCartBinding

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentCartBinding.inflate(inflater,container,false)


        val cartFoodName = listOf("Burger","Pizza","Hotdog")
        val cartItemPrice = listOf("$5","$2","$3")
        val cartImage = listOf(R.drawable.menu1,R.drawable.menu2,R.drawable.menu3)

        val adapter = cartAdapter(ArrayList(cartFoodName),ArrayList(cartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {
       
    }
}