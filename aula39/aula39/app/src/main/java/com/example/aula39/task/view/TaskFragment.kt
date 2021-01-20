package com.example.aula39.task.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aula39.R
import com.example.aula39.db.AppDatabase
import com.example.aula39.task.entity.TaskEntity
import com.example.aula39.task.repository.TaskRepository
import com.example.aula39.task.viewmodel.TaskViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout

class TaskFragment : Fragment() {
    lateinit var _view: View
    lateinit var _viewModel: TaskViewModel
    lateinit var _adapter: TaskAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        bindEvents()
        _viewModel = ViewModelProvider(
            this,
            TaskViewModel.TaskViewModelFactory(
                TaskRepository(
                    AppDatabase.getDatabase(_view.context).taskDao()
                )
            )
        ).get(TaskViewModel::class.java)

        val recyclerView = _view.findViewById<RecyclerView>(R.id.recyclerTask)
        val manager = LinearLayoutManager(_view.context)
        _adapter = TaskAdapter()

        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _adapter
        }

        bindEvents()
        initialize()
        deleteItem()
    }

    private fun initialize() {
        _viewModel.getTasks().observe(viewLifecycleOwner, Observer {
            _adapter.addTasks(it)
        })
    }

    private fun bindEvents() {
        _view.findViewById<Button>(R.id.btnAddTask).setOnClickListener {
            val edtTarefa = _view.findViewById<EditText>(R.id.textTask)
            val tarefa = edtTarefa.text.toString()
            edtTarefa.setText("")

            val params = tarefa.split(";")

            if (params.size>1) { //
                _viewModel.updateTask(params[0].toLong(), params[1])
                    .observe(viewLifecycleOwner, Observer {
                        _adapter.update(TaskEntity(params[0].toLong(), params[1]))
                    })
            } else {
                _viewModel.addTask(tarefa).observe(viewLifecycleOwner, Observer {
                    _adapter.addTask(it)
                })
            }
        }
    }

    private fun deleteItem(){
        _view.findViewById<Button>(R.id.btnRemoveTask).setOnClickListener{
            val edtTarefa = _view.findViewById<EditText>(R.id.textTask)
            val tarefa = edtTarefa.text.toString()


            _viewModel.deleteTask(tarefa.toLong()).observe(viewLifecycleOwner, Observer {
                _adapter.delete(tarefa.toLong())
            })
        }
    }
}