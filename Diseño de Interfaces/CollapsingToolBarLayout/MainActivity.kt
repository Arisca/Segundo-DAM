package com.example.travel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebSettings
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.*

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.adapter = FragmentAdapterPager(supportFragmentManager)
        viewPager.setPageTransformer(true, ZoomPageTransformer())

        val tabLayout = findViewById(R.id.appbartabs) as TabLayout
        tabLayout.setupWithViewPager(viewPager)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_tar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            (R.id.action_settings) -> {return true}
            (R.id.action_search) -> {return true}
            (R.id.action_add) -> {return true}
            else -> {return super.onOptionsItemSelected(item)} }
    }
}


