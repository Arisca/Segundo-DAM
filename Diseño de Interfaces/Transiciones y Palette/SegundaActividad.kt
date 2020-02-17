package com.example.transicionesypalette

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.palette.graphics.Palette

class SegundaActividad : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        val v : Button = findViewById(R.id.v)
        val lv : Button = findViewById(R.id.lv)
        val dv : Button = findViewById(R.id.dv)
        val m : Button = findViewById(R.id.m)
        val lm : Button = findViewById(R.id.lm)
        val dm : Button = findViewById(R.id.dm)
        val fondo : ImageView = findViewById(R.id.fondo)
        val texto: TextView = findViewById(R.id.textView)
        val imagen = findViewById<ImageView>(R.id.imageView)

        val bundle = intent.extras
        val colores = bundle!!.getInt("imagen")
        imagen.setImageResource(bundle!!.getInt("imagen"))
        texto.text = bundle.getString("nombre")

        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, colores)

        Palette.from(bitmap).generate()
        {
            val vibrant: Palette.Swatch? = it?.vibrantSwatch
            v.setBackgroundColor(vibrant!!.rgb)
            val darkvibrant: Palette.Swatch? = it.darkVibrantSwatch
            dv.setBackgroundColor(darkvibrant!!.rgb)
            val lightvibrant: Palette.Swatch? = it.lightVibrantSwatch
            lv.setBackgroundColor(lightvibrant!!.rgb)
            val muted: Palette.Swatch? = it.mutedSwatch
            m.setBackgroundColor(muted!!.rgb)
            val darkmuted: Palette.Swatch? = it.darkMutedSwatch
            dm.setBackgroundColor(darkmuted!!.rgb)
            val lightmuted: Palette.Swatch? = it.lightMutedSwatch
            lm.setBackgroundColor(lightmuted!!.rgb)


            v.setOnClickListener()
            {
                texto.setTextColor(vibrant.rgb)
                fondo.setColorFilter(vibrant.rgb)
            }
            lv.setOnClickListener()
            {
                texto.setTextColor(lightvibrant.rgb)
                fondo.setColorFilter(lightvibrant.rgb)
            }
            dv.setOnClickListener()
            {
                texto.setTextColor(darkvibrant.rgb)
                fondo.setColorFilter(darkvibrant.rgb)
            }
            m.setOnClickListener()
            {
                texto.setTextColor(muted.rgb)
                fondo.setColorFilter(muted.rgb)
            }
            lm.setOnClickListener()
            {
                texto.setTextColor(lightmuted.rgb)
                fondo.setColorFilter(lightmuted.rgb)
            }
            dm.setOnClickListener()
            {
                texto.setTextColor(darkmuted.rgb)
                fondo.setColorFilter(darkmuted.rgb)
            }
        }
    }
}
