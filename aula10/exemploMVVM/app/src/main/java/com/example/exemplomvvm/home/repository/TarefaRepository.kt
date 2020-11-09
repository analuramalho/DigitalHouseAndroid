package com.example.exemplomvvm.home.repository

import com.example.exemplomvvm.home.model.Tarefa
import java.util.*
import javax.security.auth.callback.Callback

class TarefaRepository {
    fun obterTarefas(callback: (tarefas: List<Tarefa> ) -> Unit){
        val listaDeTarefas = obterDoBanco()
        callback.invoke(listaDeTarefas)
    }

    fun obterDoBanco():List<Tarefa>{
        return listOf(
            Tarefa("Tarefa1",Date(),"TODO"),
            Tarefa("Tarefa2", Date(),"TODO"),
            Tarefa("Tarefa3",Date(),"TODO")
        )
    }
}