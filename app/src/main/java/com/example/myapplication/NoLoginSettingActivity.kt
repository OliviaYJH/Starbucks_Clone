package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.databinding.ActivityNoLoginSettingBinding

class NoLoginSettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoLoginSettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNoLoginSettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSettingLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}