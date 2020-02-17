package com.example.adivinaelnmero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    private Button comenzar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comenzar = findViewById(R.id.empezar);

        comenzar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent comienzo = new Intent(MainActivity.this, Start.class);
                MainActivity.this.startActivity(comienzo);
            }
        });
    }
}
