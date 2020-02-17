package com.example.tween

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vibrar: Button = findViewById(R.id.button_vibrate) as Button

        vibrar.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {
                val animation: Animation =
                    AnimationUtils.loadAnimation(this@MainActivity, R.anim.vibrar)
                    vibrar.startAnimation(animation)

                Handler().postDelayed({
                    val intent = Intent (this@MainActivity, activity2::class.java)
                    startActivity(intent)
                }, 500)
            }
        })

        val show: Button = findViewById(R.id.button_show) as Button
        val hide: Button = findViewById(R.id.button_hide) as Button
        val hello: ImageView = findViewById(R.id.imageView) as ImageView
        show.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {
                val animation: Animation =
                    AnimationUtils.loadAnimation(this@MainActivity, R.anim.translateshow)
                    hello.startAnimation(animation)

                show.setVisibility(View.GONE)
                hide.setVisibility(View.VISIBLE)
            }
        })

        hide.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {
                val animation: Animation =
                    AnimationUtils.loadAnimation(this@MainActivity, R.anim.translatehide)
                    hello.startAnimation(animation)

                show.setVisibility(View.VISIBLE)
                hide.setVisibility(View.GONE)
            }
        })
    }
}

