package com.example.adivinaelnmero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ganar extends AppCompatActivity
{

    private Button volver;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganar);

    volver = findViewById(R.id.Volver);
        volver.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent start = new Intent(ganar.this, juego.class);
                ganar.this.startActivity(start);
            }
        });
    }
}
