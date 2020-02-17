package com.example.travel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import android.view.MenuItem

class AdaptadorCards(var items: ArrayList<Card>) : RecyclerView.Adapter<AdaptadorCards.TarjViewHolder>() {

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imag : ImageView
        var toolcard : Toolbar

        init {
            imag = itemView.findViewById(R.id.img1)
            toolcard = itemView.findViewById(R.id.tbCard)
        }

        fun bindTarjeta(t: Card) {
            imag.setImageResource(t.foto)
            toolcard.menu.clear()
            toolcard.inflateMenu(R.menu.menu_tar)
            toolcard.title = t.titulo
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        var itemCard = items[pos]
        viewHolder.bindTarjeta(itemCard)

        viewHolder.toolcard.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem): Boolean {
                when (item.getItemId()) {
                    R.id.action_añadir -> {
                        items.add(pos, Card(itemCard.foto, itemCard.titulo))
                        notifyItemInserted(pos)
                    }
                    R.id.action_eliminar -> {
                        items.removeAt(pos)
                        notifyItemRemoved(pos)
                    }
                }
                return true
            }
        })
    }

    override fun getItemCount(): Int {
        return items.size
    }
}