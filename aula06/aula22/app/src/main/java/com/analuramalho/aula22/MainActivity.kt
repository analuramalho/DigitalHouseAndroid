package com.analuramalho.aula22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager=LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter=MeuAdapter(arrayListOf("Laranja","Morango","Sorvete","Peixe"))

        recyclerView.apply {
            setHasFixedSize(true)//dizer que os elementos não são dinamicos

            layoutManager = viewManager
            adapter=viewAdapter
            addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        }
    }
}