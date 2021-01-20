package com.example.aula39.task.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="tarefa")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    var id:Long,
    @ColumnInfo
    var tarefa:String
)