package com.example.segundaevaluacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.pagina1, container, false)

        var items: ArrayList<Card>? = null

        items = ArrayList<Card>()
        items.add(Card(R.drawable.imagen1, "Card 1"))
        items.add(Card(R.drawable.imagen2, "Card 2"))
        items.add(Card(R.drawable.imagen3, "Card 3"))
        items.add(Card(R.drawable.imagen4, "Card 4"))
        items.add(Card(R.drawable.imagen5, "Card 5"))
        items.add(Card(R.drawable.imagen6, "Card 6"))

        val recView = rootView.findViewById(R.id.recView) as RecyclerView
        val adaptador = AdaptadorCards(items)

        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(activity, 2)
        recView.itemAnimator = DefaultItemAnimator()

        return rootView
    }
}
