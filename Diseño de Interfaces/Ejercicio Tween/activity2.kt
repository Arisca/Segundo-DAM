package com.example.tween

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

class activity2 : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity2)

        val ver: Button = findViewById(R.id.button_ver) as Button
        val imagen: ImageView = findViewById(R.id.imageView2) as ImageView

        ver.setOnClickListener(object : View.OnClickListener
        {
            override fun onClick(v: View?)
            {
                val animation: Animation =
                    AnimationUtils.loadAnimation(this@activity2, R.anim.alpha)
                    imagen.startAnimation(animation)

                Handler().postDelayed({
                    val intent = Intent (this@activity2, Activity3::class.java)
                    Toast.makeText(this@activity2, "Now we move on to the next animation", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }, 2500)
            }
        })
    }
}
