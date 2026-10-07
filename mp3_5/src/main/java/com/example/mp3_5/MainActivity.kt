package com.example.mp3_5

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val images = intArrayOf(
        R.drawable.cat1, R.drawable.cat2, R.drawable.cat3,
        R.drawable.cat4, R.drawable.cat5
    )
    private val names = arrayOf("cat1.png", "cat2.png", "cat3.png", "cat4.png", "cat5.png")
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        val textName = findViewById<TextView>(R.id.textName)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            index = (index + 1) % images.size      // 마지막 다음은 처음으로
            imageView.setImageResource(images[index])
            textName.text = names[index]
        }
    }
}