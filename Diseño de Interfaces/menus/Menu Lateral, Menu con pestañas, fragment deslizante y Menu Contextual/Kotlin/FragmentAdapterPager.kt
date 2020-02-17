package com.example.segundaevaluacion

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapterPager(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    internal val PAGE_COUNT = 3
    private val tabTitles = arrayOf("Tab 1", "Tab 2", "Tab 3")

    override fun getCount(): Int {
        return PAGE_COUNT
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null

        when (position) {
            0 -> fragment = Fragment1()
            1 -> fragment = pagina2()
            2 -> fragment = pagina3()
        }

        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabTitles[position]
    }
}