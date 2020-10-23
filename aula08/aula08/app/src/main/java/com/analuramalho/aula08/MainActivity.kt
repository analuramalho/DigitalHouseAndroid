package com.analuramalho.aula08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPager)
        val tab = findViewById<TabLayout>(R.id.tabLayout)

        //faz a ligação entre a tab e o viewPager
        tab.setupWithViewPager(pager)

        val fragment = listOf(
            MeuFragment(),MeuFragment(),MeuFragment()
        )

        val titulos = listOf(getString(R.string.home),getString(R.string.biblioteca),getString(R.string.favoritos))

        pager.adapter=ViewPagerAdapter(fragment,titulos,supportFragmentManager)

        //adicionando icones nas tabs
        tab.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_home_24)
        tab.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_library_books_24)
        tab.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_star_24)

        //notificação na tab
        tab.getTabAt(0)!!.orCreateBadge.apply {
            number=100
            maxCharacterCount=3
            isVisible=true
        }
    }
}