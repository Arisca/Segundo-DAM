package com.example.transicionesypalette

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_imagenes.*


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var items: ArrayList<Card>?

        items = ArrayList<Card>()
        items.add(Card(R.drawable.image1, "Campo de salvia nemorosa"))
        items.add(Card(R.drawable.image3, "Hydrageas blanca y azul"))
        items.add(Card(R.drawable.image4, "Jalea de mar"))
        items.add(Card(R.drawable.image5, "Campo de amapolas"))
        items.add(Card(R.drawable.image6, "Faro de Anfitrite"))
        items.add(Card(R.drawable.image7, "Pingüinos"))
        items.add(Card(R.drawable.image8, "Imagen otoñal"))

        val recycler = findViewById<RecyclerView>(R.id.recView)
        val adaptador = AdaptadorCards (items)

        recView.adapter = adaptador
        recycler.layoutManager = GridLayoutManager(this@MainActivity, 1)
        recView.itemAnimator = DefaultItemAnimator()

        adaptador.onClick = {
            val intent = Intent(this, SegundaActividad::class.java)
            val item = items.get(recView.getChildAdapterPosition(it))

            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
            options?.putString("nombre", item.titulo)
            options?.putInt("imagen", item.foto)

            intent.putExtras(options!!)
            startActivity(intent, options)

        }
    }
}

