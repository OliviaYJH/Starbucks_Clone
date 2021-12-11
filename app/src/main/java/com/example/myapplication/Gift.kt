package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.GiftBinding

data class GiftCard(val text1: String, val text2: String, val Image: Int )

class Gift: Fragment() {

    var GiftCardArrayList = ArrayList<GiftCard>()
    private lateinit var giftAdapter: GiftAdapter
    lateinit var binding: GiftBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GiftBinding.inflate(layoutInflater)

        GiftCardArrayList.add(GiftCard("배송하기", "스타벅스의 MD를\n이제 집에서 받아보세요", R.drawable.delivery))
        GiftCardArrayList.add(GiftCard("e-Gift Item", "고마운 마음,\n모바일 상품권으로 선물하세요", R.drawable.gift))
        GiftCardArrayList.add(GiftCard("e-Gift Card", "소중한 사람에게 쉽고 빠르게\n마음을 전해보세요", R.drawable.giftcard))

        giftAdapter = GiftAdapter(requireContext(), GiftCardArrayList)
        binding.listviewGift.adapter = giftAdapter

        return binding.root;


    }
}