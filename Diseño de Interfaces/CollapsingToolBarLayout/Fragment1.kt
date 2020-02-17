package com.example.travel

import android.app.Activity
import android.os.Bundle
import android.view.*
import android.widget.Toast
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
        val rootView = inflater.inflate(R.layout.activity_fragment1, container, false)

        var items: ArrayList<Card>?

        items = ArrayList()
        items.add(Card(R.drawable.whale, "Card 1"))
        items.add(Card(R.drawable.whale2, "Card 2"))
        items.add(Card(R.drawable.whale3, "Card 3"))
        items.add(Card(R.drawable.whale4, "Card 4"))
        items.add(Card(R.drawable.whale5, "Card 5"))
        items.add(Card(R.drawable.whale6, "Card 6"))
        items.add(Card(R.drawable.whale7, "Card 7"))
        items.add(Card(R.drawable.whale8, "Card 8"))

        val recView = rootView.findViewById(R.id.recView) as RecyclerView
        val adaptador = AdaptadorCards(items)
        registerForContextMenu(recView)

        recView.adapter = adaptador
        recView.layoutManager = GridLayoutManager(activity, 2)
        recView.itemAnimator = DefaultItemAnimator()
        return rootView
    }

   override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val inflater: MenuInflater
        if (v.id == android.R.id.recView) {
            inflater.inflate(R.menu.menu_context, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Editar -> {
                Toast.makeText(Activity(), "Editando", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.Eliminar -> {
                Toast.makeText(Activity(), "Eliminando", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.Compartir -> {
                Toast.makeText(Activity(), "Compartiendo", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}




