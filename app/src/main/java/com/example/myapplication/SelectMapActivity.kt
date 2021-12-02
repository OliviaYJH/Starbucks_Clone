package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivitySelectMapBinding

class SelectMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_map)

        binding.ibMap.setOnClickListener{

        }
    }
}