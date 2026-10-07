package com.example.mp4_2

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    // 슬라이드의 그림 기준 정답: 왼쪽 고양이 수 vs 오른쪽 고양이 수
    // 그림을 직접 세어서 아래 값을 바꾸세요. (기본: 오른쪽이 더 많다고 가정)
    private val leftCount = 6
    private val rightCount = 9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // 버튼 클릭 시 호출되는 메서드
    fun onClickChoice(view: View) {
        val correct = when {
            leftCount > rightCount -> R.id.btnGreater
            leftCount < rightCount -> R.id.btnLess
            else -> R.id.btnEqual
        }
        val msg = if (view.id == correct) "맞았습니다" else "틀렸습니다"
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}