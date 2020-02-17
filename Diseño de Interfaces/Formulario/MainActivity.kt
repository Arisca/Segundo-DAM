package com.example.formulario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Idioma = arrayOf ("Elige tu idioma", "Español", "English")
        val adaptador = ArrayAdapter (this, android.R.layout.simple_spinner_item, Idioma)
        val Elegir = findViewById(R.id.spinner) as Spinner
        Elegir.adapter = adaptador
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        val T = findViewById(R.id.titulo) as TextView
        val N =  findViewById(R.id.Nombre) as TextView
        val A = findViewById(R.id.Apellidos) as TextView
        val D = findViewById(R.id.Direccion) as TextView
        val L = findViewById(R.id.Localidad) as TextView
        val Pr = findViewById(R.id.Provincia) as TextView
        val Pa = findViewById(R.id.Pais) as TextView

        Elegir.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            override fun onNothingSelected(parent: AdapterView<*>?)
            {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                val opciones = findViewById(R.id.spinner) as Spinner
                val select = opciones.getSelectedItem().toString()

                    if (select == "Español")
                    {
                        T.setText ("Rellene los campos, por favor")
                        N.setText ("Nombre")
                        A.setText ("Apellidos")
                        D.setText ("Dirección")
                        L.setText ("Localidad")
                        Pr.setText ("Provincia")
                        Pa.setText ("País")
                    }
                    else if (select == "English")
                    {
                        T.setText ("Fill the fields, please")
                        N.setText ("Name")
                        A.setText ("Surnames")
                        D.setText ("Adress")
                        L.setText ("Location")
                        Pr.setText ("Province")
                        Pa.setText ("Country")
                    }
            }

        }

    }
}
