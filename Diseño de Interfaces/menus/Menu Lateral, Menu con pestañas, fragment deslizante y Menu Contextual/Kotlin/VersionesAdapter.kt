package com.example.segundaevaluacion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class VersionesAdapter(context: Context, private val versiones: ArrayList<AndroidVersion>) : ArrayAdapter <AndroidVersion>(context, R.layout.pagina2, versiones)
{
    private val mInflater: LayoutInflater

    init {
        this.mInflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return versiones.size
    }

    override fun getItem(position: Int): AndroidVersion? {
        return versiones[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        var holder: ViewHolder? = null

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_view, null)
            holder = ViewHolder()
            holder.hNombre = convertView.findViewById(R.id.textNombre) as TextView
            holder.hNumero = convertView.findViewById(R.id.textNum) as TextView
            holder.hImage = convertView.findViewById(R.id.imagefoto) as ImageView
            convertView.tag = holder
        }
        else {
            holder = convertView!!.tag as ViewHolder?
        }
        val usuarios = getItem(position)
        holder!!.hNombre!!.text = usuarios!!.nombre
        holder.hNumero!!.text = usuarios.numero
        holder.hImage!!.setImageResource(usuarios.logo)
        return convertView!!
    }

    internal inner class ViewHolder
    {
        var hNombre: TextView? = null
        var hNumero: TextView? = null
        var hImage: ImageView? = null
    }
}