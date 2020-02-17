package com.example.horscopo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre = findViewById(R.id.Name) as EditText
        val hombre = findViewById(R.id.Hombre) as RadioButton
        val mujer = findViewById(R.id.mujer) as RadioButton
        val aceptar = findViewById(R.id.aceptar) as Button

        aceptar.setOnClickListener()
        {
            if (hombre.isChecked()) {
                val leernombre = nombre.text.toString()
                val mensaje = "Bienvenido Señor " + leernombre
                val saludo = Intent(applicationContext, Second::class.java)
                saludo.putExtra("S", mensaje)
                startActivity(saludo)
            }
            else if (mujer.isChecked()) {
                val leernombre = nombre.text.toString()
                val mensaje = "Bienvenida Señora " + leernombre
                val saludo = Intent(applicationContext, Second::class.java)
                saludo.putExtra("S", mensaje)
                startActivity(saludo)

            } else if (nombre.length() == 0)
                Toast.makeText(
                    applicationContext,
                    "Debes introducir al menos el nombre para poder dirigirnos a usted",
                    Toast.LENGTH_SHORT
                ).show()
        }
    }
}












