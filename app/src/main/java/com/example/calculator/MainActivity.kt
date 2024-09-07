package com.example.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val rgOperation = findViewById<RadioGroup>(R.id.rg_Operasi)
        val btnCalculate = findViewById<Button>(R.id.btn_Hitung)

        btnCalculate.setOnClickListener {
            val number1 = etNumber1.text.toString().toDouble()
            val number2 = etNumber2.text.toString().toDouble()
            val selectedOperation = rgOperation.checkedRadioButtonId

            val result = when (selectedOperation) {
                R.id.tambah -> number1 + number2
                R.id.kurang -> number1 - number2
                R.id.kali -> number1 * number2
                R.id.bagi -> number1 / number2
                else -> 0.0
            }

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("result", result)
                putExtra("nim", "12345678")
                putExtra("nama", "Nama Anda")
            }
            startActivity(intent)
        }
    }
}