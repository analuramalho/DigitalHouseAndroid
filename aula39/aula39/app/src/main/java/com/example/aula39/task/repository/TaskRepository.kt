package com.example.aula39.task.repository

import com.example.aula39.task.entity.TaskEntity
import com.example.aula39.task.dao.TaskDao

class TaskRepository(private val taskDao: TaskDao) {

    suspend fun addTask(task: TaskEntity) = taskDao.addTask(task)

    suspend fun getTasks():List<TaskEntity> = taskDao.getTasks()

    suspend fun updateTask(task:String,id:Long)=taskDao.updateTask(task,id)

    suspend fun deleteTask(id:Long)=taskDao.deleteTask(id)
}
