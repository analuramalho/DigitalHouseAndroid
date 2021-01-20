package com.example.aula39.task.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.aula39.task.entity.TaskEntity
import com.example.aula39.task.repository.TaskRepository
import kotlinx.coroutines.Dispatchers

class TaskViewModel(private val repository: TaskRepository) : ViewModel() {

    fun addTask(task: String) = liveData(Dispatchers.IO) {
        val tarefa =TaskEntity(0,task)
        repository.addTask(TaskEntity(0,task))
        emit(tarefa)
    }

    fun getTasks() = liveData(Dispatchers.IO) {
        emit(repository.getTasks())
    }

    fun updateTask(id:Long,task:String)= liveData(Dispatchers.IO) {
        repository.updateTask(task,id)
        emit(true)
    }

    fun deleteTask(id:Long)= liveData(Dispatchers.IO) {
        repository.deleteTask(id)
        emit(true)
    }

    class TaskViewModelFactory(private val repository: TaskRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return TaskViewModel(repository) as T
        }
    }
}