package com.example.segundaevaluacion2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rectangulo = RectánguloTricolorSimple(this)
        rectangulo.setBackgroundColor(Color.WHITE)
        setContentView(rectangulo)


    }
}
