package com.example.exemplomvvm.home.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.exemplomvvm.home.model.Tarefa
import com.example.exemplomvvm.home.repository.TarefaRepository

class TarefaViewModel(
    private val repository:TarefaRepository
):ViewModel() {

    val listaDeTarefasData = MutableLiveData<List<Tarefa>>()

    fun obterTarefas(){
        repository.obterTarefas {
            listaDeTarefasData.value = it
        }
    }

    class TarefaViewModelFactory(
        private  val repository: TarefaRepository
    ):ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TarefaViewModel(repository) as T
        }
    }
}

