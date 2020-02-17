package com.example.adivinaelnmero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class juego extends AppCompatActivity
{
    private Button probando;
    private EditText numero;
    int num = 0;

    int ran = (int) (Math.random() * 100);


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

    probando = findViewById(R.id.comprueba);
    numero = findViewById(R.id.editText);

    probando.setOnClickListener(new View.OnClickListener()
    {

        public void onClick(View v)
        {

            String num = numero.getText().toString ();
            int valor = Integer.parseInt(num);

            if (valor == ran)
            {
                Intent ganar = new Intent(juego.this, ganar.class);
                juego.this.startActivity(ganar);
            }
            else
            {
                if (valor > ran)
                {
                    Toast.makeText(getApplicationContext(), "Es un número más BAJO!!!!", Toast.LENGTH_SHORT).show();
                    numero.setText ("");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Es un número más ALTO!!!!", Toast.LENGTH_SHORT).show();
                    numero.setText("");
                }
            }
            numero.requestFocus();
        }
    });

    }
}
