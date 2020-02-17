package com.example.transicionesypalette

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCards(var items: ArrayList<Card>) : RecyclerView.Adapter<AdaptadorCards.TarjViewHolder> ()
{
    lateinit var onClick: (View) -> Unit

    init {
        this.items = items
    }

    class TarjViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var img : ImageView
        var text : TextView

        init {
            img = itemView.findViewById(R.id.img)
            text = itemView.findViewById(R.id.text)
        }

        fun bindTarjeta(t: Card, onClick: (View) -> Unit) = with(itemView)
        {
            img.setImageResource(t.foto)
            text.text = t.titulo
            setOnClickListener{ onClick(itemView)}
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): TarjViewHolder
    {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.layout_imagenes, viewGroup, false)
        return TarjViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TarjViewHolder, position: Int)
    {
        var item = items.get(index = position)
        holder.bindTarjeta(item, onClick)

    }

    override fun getItemCount(): Int
    {
        return items.size
    }

}



