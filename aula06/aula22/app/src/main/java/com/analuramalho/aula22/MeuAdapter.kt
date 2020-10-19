package com.analuramalho.aula22

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MeuAdapter(private val dataSet:List<String>):RecyclerView.Adapter<MeuAdapter.MeuViewHolder>() {
    //MAPEAR OS ELEMENTOS DO XML
    class MeuViewHolder(view: View):RecyclerView.ViewHolder(view){
       //private val texto by lazy { view.findViewById(R.id.meutexto) as TextView }
       private val meuTexto:TextView = view.findViewById(R.id.meutexto)

        fun bind(string: String){
            meuTexto.text=string
        }
    }

    //INFLA O XML(A LINHA)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista,parent,false)

        return MeuViewHolder(view)
    }


    //VAI SER CHAMADO A CADA ITEM DO DATASET
    override fun onBindViewHolder(holder: MeuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    //QUANTIDADE DE ITENS DO MEU DATASET
    override fun getItemCount()=dataSet.size
}