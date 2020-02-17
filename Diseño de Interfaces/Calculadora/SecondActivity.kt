package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class SecondActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val resulta2 = intent
        val b = resulta2.extras

        val resu = b!!.getString("resu")
        val RES = findViewById(R.id.Resultado) as TextView
        RES.setText(resu)
    }
}
