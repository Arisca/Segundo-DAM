package com.example.travel

import android.os.Build
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCards(var items: ArrayList<Card>) : RecyclerView.Adapter<AdaptadorCards.TarjViewHolder>() {

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imag : ImageView
        var nombre : TextView

        init {
            imag = itemView.findViewById(R.id.img1)
            nombre = itemView.findViewById(R.id.textView)

        }

        fun bindTarjeta(t: Card) {
            imag.setImageResource(t.foto)
            nombre.setText(t.titulo)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_cards, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: TarjViewHolder, pos: Int) {
        var itemCard = items[pos]
        viewHolder.bindTarjeta(itemCard)
        
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
