package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.OtherBinding

class Other: Fragment() {

    private lateinit var binding: OtherBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = OtherBinding.inflate(layoutInflater)

        binding.ibSetting.setOnClickListener{
            Toast.makeText(activity, "Click setting", Toast.LENGTH_SHORT).show()
        }

        return binding.root;
    }






}