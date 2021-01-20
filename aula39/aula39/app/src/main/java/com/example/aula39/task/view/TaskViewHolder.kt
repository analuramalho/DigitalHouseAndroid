package com.example.aula39.task.view

import android.view.TextureView
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aula39.R
import com.example.aula39.task.entity.TaskEntity
import kotlinx.android.synthetic.main.card_list_item.view.*

class TaskViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    val txtId =view.findViewById<TextView>(R.id.txtId)
    val txtTarefa = view.findViewById<TextView>(R.id.textTaskCard)

    fun bind(task: TaskEntity){
        txtId.text =task.id.toString()
        txtTarefa.text=task.tarefa
    }

}
