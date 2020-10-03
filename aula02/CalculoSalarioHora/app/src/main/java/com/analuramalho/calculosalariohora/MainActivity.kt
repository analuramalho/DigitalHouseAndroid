package com.analuramalho.calculosalariohora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcular.setOnClickListener {
            val horas=edtHoras.text.toString().toDouble()
            val valor=edtValor.text.toString().toDouble()
            val result=horas*valor

            txtExibir.text=getString(R.string.salario,result)

        }
    }
}