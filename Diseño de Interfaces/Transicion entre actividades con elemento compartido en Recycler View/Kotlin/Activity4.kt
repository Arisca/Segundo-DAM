package com.example.tween

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class Activity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)

        val pulsar: ImageButton = findViewById(R.id.imageButton) as ImageButton
        pulsar.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {

            }
        })

    }
}
