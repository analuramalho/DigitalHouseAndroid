package com.analuramalho.aula19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vocedeseja.setOnCheckedChangeListener{_,isChecked ->
            Toast.makeText(this,"Toast", Toast.LENGTH_SHORT).show()
            btnClicar.isEnabled = isChecked

        }

        btnClicar.setOnClickListener {
            val intent= Intent(this,NovaTela::class.java)
            intent.putExtra("NOME", "Analu")
            startActivity(intent)
        }

    }
}