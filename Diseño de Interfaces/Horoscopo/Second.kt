package com.example.horscopo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*
import android.widget.*
import android.widget.DatePicker
import android.widget.CheckBox

class Second : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val saludo = intent
        val s = saludo.extras
        val salu2 = s!!.getString("S")
        val SAL = findViewById(R.id.Saludo) as TextView
        SAL.setText(salu2)

        checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            val visibility = if (isChecked) View.VISIBLE else View.GONE
            val view = findViewById(R.id.DatePicker) as DatePicker
            view.setVisibility(visibility)
        }

        val aceptar = findViewById(R.id.aceptar) as Button
        aceptar.setOnClickListener()
        {
            val saludar = SAL.text.toString()

            var dia = 0
            var mes = 0
            var anyo = 0

            val timeCheckBox =
                findViewById(R.id.checkBox) as CheckBox

            if (timeCheckBox.isChecked) {
                val date = findViewById(R.id.DatePicker) as DatePicker
                dia = date.dayOfMonth
                mes = date.month + 1
                anyo = date.year

                val fecha = date.dayOfMonth.toString() + "/" + (date.month + 1) + "/" + date.year

                val zodiaco = Intent(applicationContext, Tercero::class.java)
                zodiaco.putExtra("S", saludar)
                zodiaco.putExtra ("f", fecha)
                zodiaco.putExtra("d", dia)
                zodiaco.putExtra("m", mes)
                zodiaco.putExtra("a", anyo)
                startActivity (zodiaco)
        }
            else
            {
                Toast.makeText (applicationContext, "Introduce la fecha de tu nacimiento, por favor", Toast.LENGTH_SHORT).show()
            }
    }

    }
}



