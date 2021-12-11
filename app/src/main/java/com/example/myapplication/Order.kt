package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MenuListBinding
import com.example.myapplication.databinding.OrderBinding

class Order: Fragment() {

    private lateinit var binding: OrderBinding
    private lateinit var menubinding: MenuListBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = OrderBinding.inflate(layoutInflater)
        menubinding = MenuListBinding.inflate(layoutInflater)

        val exampleList = generateDummyList(20)
        menubinding.ivOrder.clipToOutline = true

        binding.recyclerView.adapter = ExampleAdapter(exampleList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.setHasFixedSize(true)




        binding.tvPickstore.setOnClickListener{
            startActivity(Intent(activity, SelectMapActivity::class.java))
            Toast.makeText(activity, "다음", Toast.LENGTH_SHORT).show()

        }

        return binding.root
    }

    private fun generateDummyList(size: Int): List<Menu>{


        val list = ArrayList<Menu>()

        list += Menu(R.drawable.menu_new, "New")
        list += Menu(R.drawable.cold_brew, "추천")
        list += Menu(R.drawable.reserve_expresso, "리저브 에스프레소")
        list += Menu(R.drawable.reserve_drip, "리저브 드립")
        list += Menu(R.drawable.latte, "콜드 브루")
        list += Menu(R.drawable.espresso, "에스프레소")
        list += Menu(R.drawable.frappuccino, "프라푸치노")
        list += Menu(R.drawable.citron, "피지오")
        list += Menu(R.drawable.lime, "티바나")




        return list
    }


}