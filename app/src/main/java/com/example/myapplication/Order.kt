package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.OrderBinding

class Order: Fragment() {

    private lateinit var binding: OrderBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = OrderBinding.inflate(layoutInflater)

        binding.tvPickstore.setOnClickListener{
            startActivity(Intent(activity, SelectMapActivity::class.java))
        }

        return binding.root
    }
}