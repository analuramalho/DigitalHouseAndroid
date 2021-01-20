package com.example.aula39

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aula39.task.view.TaskFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment, TaskFragment())
            .commit()
    }
}