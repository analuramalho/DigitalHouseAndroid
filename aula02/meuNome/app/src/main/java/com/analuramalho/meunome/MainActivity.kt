package com.analuramalho.meunome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnExibirNome.setOnClickListener{
            val nome = edtNome.text.toString()

            txtExibir.text=getString(R.string.mensagemNome,nome)
        }

    }
}