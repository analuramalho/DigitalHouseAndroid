package com.example.fakelogin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.viewpager.widget.ViewPager
import com.example.fakelogin2.users.UserService
import com.google.android.material.tabs.TabLayout
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.fragment_sign_in.*
import kotlinx.android.synthetic.main.fragment_sign_in.view.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPager)
        val tab = findViewById<TabLayout>(R.id.tabLayout)

        //faz a ligação entre a tab e o viewPager
        tab.setupWithViewPager(pager)

        val fragments = listOf(signInFragment(),signUpFragment())
        val titulos = listOf(getString(R.string.signIn), getString(R.string.signUp))

        pager.adapter=ViewPageAdapter(fragments,titulos,supportFragmentManager)

    }
}