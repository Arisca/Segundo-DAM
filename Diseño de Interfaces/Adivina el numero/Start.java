package com.example.adivinaelnmero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Start extends AppCompatActivity
{

    private final int duracion = 3000;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Runnable()
        {
            public void run()
            {
                Intent intent = new Intent (Start.this, juego.class);
                startActivity (intent);
                finish ();
            };
        }, duracion);
    }
}
