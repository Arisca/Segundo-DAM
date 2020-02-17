package com.example.segundaevaluacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById(R.id.tablayout) as TabLayout
        val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        val navView = findViewById(R.id.nav_view) as NavigationView
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.adapter = FragmentAdapterPager(supportFragmentManager)
        viewPager.setPageTransformer(true, ZoomPageTransformer())

        navView.setNavigationItemSelectedListener(object :  NavigationView.OnNavigationItemSelectedListener {

            override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                var fragmentTransaction = false
                var fragment: Fragment? = null

                when (menuItem.getItemId()) {
                    R.id.menu_seccion_1 -> {
                        fragment = Fragment1()
                        fragmentTransaction = true
                    }
                    R.id.menu_seccion_2 -> {
                        fragment = pagina2()
                        fragmentTransaction = true
                    }
                    R.id.menu_seccion_3 -> {
                        fragment = pagina3()
                        fragmentTransaction = true
                    }
                }
                if (fragmentTransaction) {
                    supportFragmentManager.beginTransaction().replace(R.id.content_frame, fragment!!).commit()
                    menuItem.setChecked(true)
                    supportActionBar!!.title = menuItem.title
                }
                drawerLayout.closeDrawers()
                return true
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener
        {
            var fragmentTransaction = false
            var fragment: Fragment? = null

            override fun onTabSelected(tab: TabLayout.Tab)
            {
                when (tab.position) {
                    0 -> {
                        fragment = Fragment1()
                        fragmentTransaction = true
                    }
                    1 -> {
                        fragment = pagina2()
                        fragmentTransaction = true
                    }
                    2 -> {
                        fragment = pagina3()
                        fragmentTransaction = true
                    }
                }
                if (fragmentTransaction) {
                    supportFragmentManager.beginTransaction().replace(R.id.content_frame, fragment!!).commit()
                    supportActionBar!!.setTitle(tab.text)
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        val drawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        when (item.itemId)
        {
            android.R.id.home ->
            {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return true
    }
}

