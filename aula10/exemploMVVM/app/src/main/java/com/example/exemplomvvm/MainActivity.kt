package com.example.exemplomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.exemplomvvm.home.view.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        manager.beginTransaction()
            .replace(R.id.FrameLayout,HomeFragment())
            .commit()
    }
}