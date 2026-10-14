package com.example.mp5_2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit    var    cbObj1: CheckBox
    lateinit    var    cbObj2:    CheckBox
    lateinit    var    cbObj3:    CheckBox
    lateinit    var    cbObj4:    CheckBox
    lateinit    var    btnObj: Button
    lateinit    var    tvObj: TextView
    var flag   =  false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        cbObj1=findViewById(R.id.checkBox1)
        cbObj2=findViewById(R.id.checkBox2)
        cbObj3=findViewById(R.id.checkBox3)
        cbObj4=findViewById(R.id.checkBox4)
        btnObj=findViewById(R.id.button)
        tvObj=findViewById(R.id.textViewResult)

        val listener = CompoundButton.OnCheckedChangeListener{ buttonView, isChecked ->
            // TODO :  event handler
            // 선택한 물건의 이름을 토스트로 출력
            if (isChecked) {
                val name = when (buttonView.id) {
                    R.id.checkBox1 -> "소방차"
                    R.id.checkBox2 -> "물뿌리개"
                    R.id.checkBox3 -> "청진기"
                    R.id.checkBox4 -> "장갑"
                    else -> ""
                }
                Toast.makeText(this, "${name}를 선택했습니다.", Toast.LENGTH_SHORT).show()
            }
        }

        cbObj1.setOnCheckedChangeListener(listener)
        cbObj2.setOnCheckedChangeListener(listener)
        cbObj3.setOnCheckedChangeListener(listener)
        cbObj4.setOnCheckedChangeListener(listener)

        btnObj.setOnClickListener {
            // TODO : event hander
            if (!flag) {
                // 결과보기: 정답은 소방차(1), 물뿌리개(3)
                if (cbObj1.isChecked && cbObj2.isChecked
                    && !cbObj3.isChecked && !cbObj4.isChecked) {
                    tvObj.text = "맞았습니다"
                } else {
                    tvObj.text = "틀렸습니다"
                }
                btnObj.text = "재시작하기"
                flag = true
            } else {
                // 재시작하기: 체크 해제하고 안내문으로 되돌림
                cbObj1.isChecked = false
                cbObj2.isChecked = false
                cbObj3.isChecked = false
                cbObj4.isChecked = false
                tvObj.text = "소방관의 용품을 선택해주세요"
                btnObj.text = "결과보기"
                flag = false
            }
        }
    }
}