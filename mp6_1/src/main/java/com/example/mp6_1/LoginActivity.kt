package com.example.mp6_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 아이디, 비밀번호 입력란과 로그인 버튼 객체 가져오기
        val	etObj01 : EditText = findViewById(R.id.editText01)
        val	etObj02 : EditText = findViewById(R.id.editText02)
        val	btnObj : Button = findViewById(R.id.button)

        // <로그인> 버튼을 클릭하면 입력한 로그인 정보를 토스트로 출력
        btnObj.setOnClickListener {
            val	id = etObj01.text.toString()
            val	passwd = etObj02.text.toString()
            Toast.makeText(
                applicationContext,
                "아이디 : " + id + "\n비밀번호 : " + passwd,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
