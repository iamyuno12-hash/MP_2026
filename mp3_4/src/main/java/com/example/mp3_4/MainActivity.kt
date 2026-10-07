package com.example.mp3_4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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
            v.setPadding(systemBars.left + 40, systemBars.top, systemBars.right + 40, systemBars.bottom)
            insets
        }

        val editName = findViewById<EditText>(R.id.editName)
        val editPw = findViewById<EditText>(R.id.editPw)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editBirth = findViewById<EditText>(R.id.editBirth)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val btnResult = findViewById<Button>(R.id.btnResult)
        val textResult = findViewById<TextView>(R.id.textResult)

        btnResult.setOnClickListener {
            textResult.text = """
                성명 - ${editName.text}
                비밀번호 - ${editPw.text}
                이메일 - ${editEmail.text}
                생년월일 - ${editBirth.text}
                연락처 - ${editPhone.text}
            """.trimIndent()
        }
    }
}