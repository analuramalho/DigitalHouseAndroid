package com.example.aula39.task.dao

import androidx.room.*
import com.example.aula39.task.entity.TaskEntity

@Dao
interface TaskDao {

    @Insert
    suspend fun addTask(task: TaskEntity)

    @Query("SELECT * FROM tarefa")
    suspend fun getTasks():List<TaskEntity>


    //duas formas de fazer update o mesmo para delete
    @Transaction
    @Query("UPDATE tarefa SET tarefa =:task where id=:id")
    suspend  fun updateTask(task:String, id:Long)

/*    @Update @Transaction
    fun updateTask(task:TaskEntity)*/

    @Transaction
    @Query("DELETE FROM tarefa where id=:id")
    suspend  fun deleteTask(id:Long)

}
