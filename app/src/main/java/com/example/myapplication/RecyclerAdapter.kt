package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.MenuListBinding


class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.MenuViewHolder>() {

    private lateinit var binding: MenuListBinding
    private var titles = arrayOf("NEW", "추천천")
    private var images = intArrayOf(R.drawable.citron, R.drawable.citron)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.menu_list, parent, false)
        return MenuViewHolder(v)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        binding.ivOrder.setImageResource(images[position])
        binding.tvMenuOrder.text = titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    class MenuViewHolder(var view: View): RecyclerView.ViewHolder(view){
        private var img = view.findViewById<ImageView>(R.id.iv_order)
        private var text = view.findViewById<TextView>(R.id.tv_menu_order)


    }
}



