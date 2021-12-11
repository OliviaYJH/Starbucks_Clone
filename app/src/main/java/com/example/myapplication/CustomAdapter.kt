package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.databinding.ListviewItemBinding

class CustomAdapter(context: Context, private val businessCardArrayList: ArrayList<BusinessCard>) : BaseAdapter(){

    var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private lateinit var binding: ListviewItemBinding

    override fun getCount(): Int = businessCardArrayList.size

    override fun getItem(p0: Int): Any = businessCardArrayList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        binding = ListviewItemBinding.inflate(inflater, p2, false)
        binding.tvName.text = businessCardArrayList[position].contents
        binding.sw.isChecked = businessCardArrayList[position].isSwitched
        binding.sw.setOnCheckedChangeListener{buttonView, isChecked ->
            businessCardArrayList[position].isSwitched = isChecked
        }

        return binding.root

    }
}