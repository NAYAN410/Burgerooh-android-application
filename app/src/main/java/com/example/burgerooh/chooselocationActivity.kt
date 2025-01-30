package com.example.burgerooh

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.burgerooh.databinding.ActivityChooselocationBinding

class chooselocationActivity : AppCompatActivity() {
    private val binding: ActivityChooselocationBinding by lazy {
        ActivityChooselocationBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        val localeList = arrayListOf("jaipur", "Odisha")
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, localeList)
       val autoCompleteTextView = binding.listOfLocation
        autoCompleteTextView.setAdapter(adapter)

    }
}