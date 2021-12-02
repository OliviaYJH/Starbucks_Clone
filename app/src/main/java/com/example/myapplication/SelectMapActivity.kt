package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivitySelectMapBinding
import com.example.myapplication.databinding.OrderBinding

class SelectMapActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySelectMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySelectMapBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.ibMap.setOnClickListener {
            Toast.makeText(this, "ibMap 눌림", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MapsActivity::class.java))
        }
    }
}