package com.example.aula39.task.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.aula39.R
import com.example.aula39.task.entity.TaskEntity

class TaskAdapter(): RecyclerView.Adapter<TaskViewHolder>() {
    private val _tasks:MutableList<TaskEntity> = mutableListOf()

    fun addTask(task:TaskEntity){
        _tasks.add(task)
        notifyDataSetChanged()
    }

    fun addTasks(tasks: List<TaskEntity>) {
        _tasks.addAll(tasks)
        notifyDataSetChanged()
    }

    fun update(taskEntity: TaskEntity) {
        for(tasks in _tasks){
            if(tasks.id == taskEntity.id){
                tasks.tarefa=taskEntity.tarefa
                break
            }
        }
        notifyDataSetChanged()
    }

    fun delete(id:Long){
        for(tasks in _tasks){
            if(tasks.id == id){
                _tasks.remove(tasks)
                break
            }
        }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_list_item,parent,false )
        return TaskViewHolder(view)
    }

    override fun getItemCount()=_tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = _tasks[position]

        holder.bind(item)
    }

}