package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.util.isNotEmpty
import com.example.myapplication.databinding.ActivitySettingBinding
import com.example.myapplication.databinding.HomeBinding

data class BusinessCard(val contents: String, var isSwitched: Boolean = false)

class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    private lateinit var sharedPreferences: SharedPreferences


    var businessCardArrayList = ArrayList<BusinessCard>()
    private lateinit var customAdapter: CustomAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        businessCardArrayList.add(BusinessCard("푸시 알림"))
        businessCardArrayList.add(BusinessCard("프로모션/이벤트 알림 수신"))
        businessCardArrayList.add(BusinessCard("Shake to pay 설정"))
        businessCardArrayList.add(BusinessCard("위치 정보 서비스 이용약관 동의"))

        customAdapter = CustomAdapter(this, businessCardArrayList)
        binding.listview.adapter = customAdapter



        
        binding.btnLogout.setOnClickListener{
            // 로그인 정보 삭제
            sharedPreferences = getSharedPreferences("check_login", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear()
            editor.commit()

            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}

