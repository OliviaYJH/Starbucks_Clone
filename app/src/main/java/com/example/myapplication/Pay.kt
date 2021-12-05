package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.PayBinding
import kotlin.concurrent.thread

class Pay: Fragment() {

    private lateinit var binding: PayBinding
    var totalTime = 60 * 10// 10분
    var started = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PayBinding.inflate(layoutInflater)

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = object:Handler(Looper.getMainLooper()){
            override fun handleMessage(msg: Message) {
                val minute = String.format("%02d", totalTime/60)
                val second = String.format("%02d", totalTime%60)

                binding.tvLimittime.text = "$minute:$second" // 텍스트 바꿔주기
            }
        }
        started = true
        thread(started){
            while(true){
                Thread.sleep(1000)
                totalTime -= 1
                handler?.sendEmptyMessage(0)

                if(totalTime == 0){
                    binding.tvLimittime.text = "만료되었습니다"
                    totalTime = 0
                    break
                }
            }
        }

    }

    override fun onStop() {
        super.onStop()
        totalTime = 0
    }

    override fun onResume() {
        super.onResume()
        totalTime = 60* 10
    }

}