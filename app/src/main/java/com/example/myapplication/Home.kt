package com.example.myapplication


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.HomeBinding

class Home : Fragment(){

    var sentenceArray = arrayOf("찬 바람 불어오는 겨울\n감기 조심하세요", "오늘 같은 오후엔\n스노우 민트초콜릿", "추운 겨울엔 역시\n따뜻한 릴렉서 한 잔")

    private lateinit var binding: HomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeBinding.inflate(layoutInflater)

        binding.ivLatte.clipToOutline = true
        binding.ivFrappuccino.clipToOutline = true
        binding.ivCitron.clipToOutline = true
        binding.ivLime.clipToOutline = true

        return binding.root;
    }


    override fun onResume() {
        super.onResume()

        val range = (0..2)
        binding.tvTop.text = sentenceArray[range.random()] // 텍스트 바꾸기

    }
}