package com.example.mp4_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 주사위 이미지 리소스 배열 선언
    private val diceNumber = intArrayOf(
        R.drawable.dice1, R.drawable.dice2,
        R.drawable.dice3, R.drawable.dice4,
        R.drawable.dice5, R.drawable.dice6
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageDiceA = findViewById<ImageView>(R.id.imageDiceA)
        val imageDiceB = findViewById<ImageView>(R.id.imageDiceB)
        val editSum = findViewById<EditText>(R.id.editSum)
        val btnResult = findViewById<Button>(R.id.btnResult)

        // 주사위 값 랜덤으로 설정 (0~5 인덱스 → 숫자는 +1)
        val numA = (Math.random() * 6).toInt() + 1
        val numB = (Math.random() * 6).toInt() + 1
        imageDiceA.setImageResource(diceNumber[numA - 1])
        imageDiceB.setImageResource(diceNumber[numB - 1])

        btnResult.setOnClickListener {
            val input = editSum.text.toString().toIntOrNull()
            val msg = if (input == numA + numB) "맞았습니다" else "틀렸습니다"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }
}