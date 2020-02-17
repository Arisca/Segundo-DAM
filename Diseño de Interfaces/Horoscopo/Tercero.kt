package com.example.horscopo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Tercero : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tercero)

        val saludar = intent
        val s = saludar.extras
        val salu2 = s!!.getString("S")
        val salu = findViewById(R.id.SALU2) as TextView
        salu.setText(salu2)

        val fecha_nacimiento = intent
        val f = fecha_nacimiento.extras
        val fecha = f!!.getString("f")
        val f_n = findViewById(R.id.NACI) as TextView
        f_n.setText("Ha nacido el día: " + fecha)

        val signo = findViewById(R.id.signo) as ImageView

        val dia = intent
        val d = dia.extras
        var DIA = d!!.getInt("d")

        val mes = intent
        val m = mes.extras
        var MES = m!!.getInt("m")

        if (DIA >= 20 && MES == 1 || DIA <= 19 && MES == 2) {
            signo.setBackgroundResource(R.drawable.acuario)
        }
        if (DIA >= 19 && MES == 2 || DIA <= 20 && MES == 3) {
            signo.setBackgroundResource(R.drawable.piscis)
        }
        if (DIA >= 21 && MES == 3 || DIA <= 19 && MES == 4) {
            signo.setBackgroundResource(R.drawable.aries)
        }
        if (DIA >= 20 && MES == 4 || DIA <= 20 && MES == 5) {
            signo.setBackgroundResource(R.drawable.taurus)
        }
        if (DIA >= 21 && MES == 5 || DIA <= 20 && MES == 6) {
            signo.setBackgroundResource(R.drawable.geminis)
        }
        if (DIA >= 21 && MES == 6 || DIA <= 22 && MES == 7) {
            signo.setBackgroundResource(R.drawable.cancer)
        }
        if (DIA >= 23 && MES == 7 || DIA <= 22 && MES == 8) {
            signo.setBackgroundResource(R.drawable.leo)
        }
        if (DIA >= 23 && MES == 8 || DIA <= 22 && MES == 9) {
            signo.setBackgroundResource(R.drawable.virgo)
        }
        if (DIA >= 23 && MES == 9 || DIA <= 22 && MES == 10) {
            signo.setBackgroundResource(R.drawable.libra)
        }
        if (DIA >= 23 && MES == 10 || DIA <= 21 && MES == 11) {
            signo.setBackgroundResource(R.drawable.escorpio)
        }
        if (DIA >= 22 && MES == 11 || DIA <= 21 && MES == 12) {
            signo.setBackgroundResource(R.drawable.sagitario)
        }
        if (DIA >= 22 && MES == 12 || DIA <= 19 && MES == 1) {
            signo.setBackgroundResource(R.drawable.capricornio)
        }
    }
}
