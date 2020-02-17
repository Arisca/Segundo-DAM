package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


open class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Opera = arrayOf("...", "Sumar", "Restar", "Multiplicar", "Dividir")
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item, Opera)
        val list_opera = findViewById(R.id.Opciones) as Spinner
        list_opera.adapter = adaptador as SpinnerAdapter?;
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        var Calcular = findViewById<Button>(R.id.Calcular)

        Calcular.setOnClickListener()
        {
            val num1 = findViewById(R.id.num1) as EditText
            val num2 = findViewById(R.id.num2) as EditText

            val opciones = findViewById(R.id.Opciones) as Spinner
            val select = opciones.getSelectedItem().toString()

            if (select == "...")
            {
                Toast.makeText(applicationContext, "Debes seleccionar alguna opción de calculo", Toast.LENGTH_SHORT).show()
            }
            else if (select == "Sumar")
            {
                val suma = (Integer.parseInt(num1.text.toString())) + (Integer.parseInt(num2.text.toString()))
                val resu = suma.toString()
                val resulta2 = Intent(applicationContext, SecondActivity::class.java)
                resulta2.putExtra("resu", resu)
                startActivity(resulta2)
            }
            else if (select == "Restar")
            {
                val resta = (Integer.parseInt(num1.text.toString())) - (Integer.parseInt(num2.text.toString()))
                val resu = resta.toString()
                val resulta2 = Intent(applicationContext, SecondActivity::class.java)
                resulta2.putExtra("resu", resu)
                startActivity(resulta2)

            }
            else if (select == "Multiplicar")
            {
                val multi = (Integer.parseInt(num1.text.toString())) * (Integer.parseInt(num2.text.toString()))
                val resu = multi.toString()
                val resulta2 = Intent(applicationContext, SecondActivity::class.java)
                resulta2.putExtra("resu", resu)
                startActivity(resulta2)

            }
            else if (select == "Dividir")
            {
                val dividir = (Integer.parseInt(num1.text.toString())) / (Integer.parseInt(num2.text.toString()))
                val resu = dividir.toString()
                val resulta2 = Intent(applicationContext, SecondActivity::class.java)
                resulta2.putExtra("resu", resu)
                startActivity(resulta2)
          }
        }
    }
}




