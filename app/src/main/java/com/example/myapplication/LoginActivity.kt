package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener{
            sharedPreferences = getSharedPreferences("check_login", MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("IsLogined", true) // 자동 로그인 상태됨
            editor.commit()
            
            startActivity(Intent(this, MainActivity::class.java))
            onDestroy() // 로그인하면 destory하기
        }
    }

    override fun onStart() {
        super.onStart()

        sharedPreferences = getSharedPreferences("check_login", MODE_PRIVATE)
        if((sharedPreferences != null) && (sharedPreferences.contains("IsLogined"))){
            var autoLogin = sharedPreferences.getBoolean("IsLogined",true)

            if(autoLogin){ // 자동 로그인
                startActivity(Intent(this, MainActivity::class.java))
            }

        }
    }

    override fun onPause() {
        super.onPause()
        saveLogin()
    }

    override fun onResume() {
        super.onResume()
        restoreLogin()
    }

    fun saveLogin(){
        val userid = binding.etId.text.toString()
        val password = binding.etPassword.toString()

        sharedPreferences = getSharedPreferences("check_login", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString("UserID",userid)
        editor.putString("Password", password)
        editor.putBoolean("IsLogined", false)
        editor.commit()
    }

    fun restoreLogin(){
        sharedPreferences = getSharedPreferences("check_login", MODE_PRIVATE)
        if((sharedPreferences != null) && (sharedPreferences.contains("UserID"))){
            var storeid = sharedPreferences.getString("UserID", "")
            binding.etId.setText(storeid)
        }
    }

}