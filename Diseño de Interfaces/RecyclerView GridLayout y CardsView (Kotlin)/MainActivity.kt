package com.example.travel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DefaultItemAnimator



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        var items: ArrayList<Card>? = null

            items = ArrayList<Card>()
            items!!.add(Card(R.drawable.whale, "Card 1"))
            items!!.add(Card(R.drawable.whale2,"Card 2"))
            items!!.add(Card(R.drawable.whale3,"Card 3"))
            items!!.add(Card(R.drawable.whale4,"Card 4"))
            items!!.add(Card(R.drawable.whale5,"Card 5"))
            items!!.add(Card(R.drawable.whale6,"Card 6"))
            items!!.add(Card(R.drawable.whale7,"Card 7"))
            items!!.add(Card(R.drawable.whale8,"Card 8"))

            val toolbar = findViewById(R.id.toolbar) as Toolbar
            setSupportActionBar(toolbar)

            val recView = findViewById(R.id.recView) as RecyclerView
            val adaptador = AdaptadorCards(items!!)

            recView.adapter = adaptador
            recView.layoutManager = GridLayoutManager(this, 2)
            recView.itemAnimator = DefaultItemAnimator()
    }
}

