package com.example.mp3_3

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
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

    // XML의 android:onClick="sumClick" 과 이름이 같아야 함
    fun sumClick(view: View) {
        val n1 = findViewById<TextView>(R.id.num1).text.toString().toInt()
        val n2 = findViewById<TextView>(R.id.num2).text.toString().toInt()
        Toast.makeText(this, "합계: ${n1 + n2}", Toast.LENGTH_SHORT).show()
    }
}