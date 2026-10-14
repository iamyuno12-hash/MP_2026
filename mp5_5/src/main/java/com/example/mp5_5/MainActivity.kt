package com.example.mp5_5

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit    var    sObj1: Switch
    lateinit    var    sObj2: Switch
    lateinit    var    tvObj: TextView
    lateinit    var    ivObj1: ImageView
    lateinit    var    ivObj2:    ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        sObj1=findViewById(R.id.switch1)
        sObj2=findViewById(R.id.switch2)
        sObj2.textOn = ""
        sObj2.textOff = ""
        tvObj=findViewById(R.id.textView2)
        ivObj1=findViewById(R.id.imageView1)
        ivObj2=findViewById(R.id.imageView2)

        sObj1.setOnCheckedChangeListener{   buttonView,    isChecked->
            // TODO : event handler
            // 고양이 스위치: ON이면 창문에 고양이가 나타남
            if (isChecked) {
                ivObj1.visibility = View.VISIBLE
            } else {
                ivObj1.visibility = View.INVISIBLE
            }
        }
        sObj2.setOnCheckedChangeListener{   buttonView,       isChecked->
            // TODO  event handler
            // 라이트 스위치: ON이면 조명이 켜짐
            if (isChecked) {
                ivObj2.setImageResource(R.drawable.light32)
                tvObj.text = "ON"
                tvObj.setTextColor(Color.parseColor("#4CAF50"))
            } else {
                ivObj2.setImageResource(R.drawable.light31)
                tvObj.text = "OFF"
                tvObj.setTextColor(Color.RED)
            }
        }
    }
}