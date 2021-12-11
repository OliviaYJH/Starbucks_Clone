package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.myapplication.databinding.ListitemGiftBinding

class GiftAdapter(context: Context, private val GiftCardArrayList:ArrayList<GiftCard>):BaseAdapter() {

    val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    lateinit var binding: ListitemGiftBinding

    override fun getCount(): Int = GiftCardArrayList.size

    override fun getItem(p0: Int): Any = GiftCardArrayList[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        binding = ListitemGiftBinding.inflate(inflater, p2, false)
        binding.tvGiftFirst.text = GiftCardArrayList[p0].text1
        binding.tvGiftSecond.text = GiftCardArrayList[p0].text2
        binding.ivGift.setImageResource(GiftCardArrayList[p0].Image)

        return binding.root
    }
}