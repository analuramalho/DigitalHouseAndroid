package com.analuramalho.conversor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConverter.setOnClickListener {
            val C: Double=edtConversor.text.toString().toDouble()
            val F: Double= (C*9/5)+32
            txtExibir.text=getString(R.string.fahrenheit,F)
        }
    }
}