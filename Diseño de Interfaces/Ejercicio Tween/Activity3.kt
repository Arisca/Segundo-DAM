package com.example.tween

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.ViewAnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory

class Activity3 : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val kitty: ImageView = findViewById(R.id.imageView3) as ImageView
        val circular: Button = findViewById (R.id.button_circular) as Button

        circular.setOnClickListener(View.OnClickListener { v ->
            val cx = kitty.getWidth() / 2
            val cy = kitty.getHeight() / 2

            val radius = calculateMaxRadius(v)

            val anim = ViewAnimationUtils.createCircularReveal(kitty, cx, cy, radius, 0f)
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    kitty.setVisibility(View.INVISIBLE)
                }
            })
            anim.duration = 2000
            anim.start()

            Handler().postDelayed({
                val intent = Intent (this@Activity3, Activity4::class.java)
                Toast.makeText(this@Activity3, "And we continue on to the next animation", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }, 2500)
        })
    }
}
    fun calculateMaxRadius(view: View): Float
    {
        val widthSquared = view.getWidth() * view.getWidth()
        val heightSquared = view.getHeight() * view.getHeight()
        return Math.sqrt((widthSquared + heightSquared / 2).toDouble()).toFloat()
    }

