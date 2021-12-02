package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(){

    private val fragments_frame: FrameLayout by lazy {
        findViewById(R.id.fragments_frame)
    }

    private val navigationbar: BottomNavigationView by lazy {
        findViewById(R.id.navigationbar)
    }

    //private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root

        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(fragments_frame.id, Home()).commit()

        navigationbar.setOnItemSelectedListener {
            replaceFragment(
                when(it.itemId){
                    R.id.home -> Home()
                    R.id.pay -> Pay()
                    R.id.order -> Order()
                    R.id.gift -> Gift()
                    else -> Other()
                }
            )
            true
        }

    }


    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(fragments_frame.id, fragment).commit()
    }



}