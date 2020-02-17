package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private TextView titulo;
    private Typeface tipoletra;
    private Button comenzar;
    private EditText j1;
    private EditText j2;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

    titulo = findViewById(R.id.titulo);
    String fuente = "MixyMissy-PersonalUse.ttf";
    this.tipoletra = Typeface.createFromAsset(getAssets(), fuente);
    titulo.setTypeface (tipoletra);

    comenzar = findViewById(R.id.start);
    comenzar.setOnClickListener( new View.OnClickListener()
    {
        public void onClick(View v)
        {
            j1 = findViewById( R.id.Jugador1);
            j2 = findViewById( R.id.Jugador2);
            String jugador1 = j1.getText().toString();
            String jugador2 = j2.getText().toString();

            Intent nombres = new Intent (getApplicationContext(), juego.class);
            nombres.putExtra ("jugador1", jugador1);
            nombres.putExtra ("jugador2", jugador2);

            startActivity (nombres);
        }
    } );
    }
}
