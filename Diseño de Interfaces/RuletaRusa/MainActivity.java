package com.example.ruletarusa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private Button reload;
    private Button bala1;
    private Button bala2;
    private Button bala3;
    private Button bala4;
    private Button bala5;
    private Button bala6;
    private ImageView imagen;
    private TextView texto;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    reload = findViewById(R.id.reload);
    bala1 = findViewById(R.id.button1);
    bala2 = findViewById(R.id.button2);
    bala3 = findViewById(R.id.button3);
    bala4 = findViewById(R.id.button4);
    bala5 = findViewById(R.id.button5);
    bala6 = findViewById(R.id.button6);
    imagen = findViewById(R.id.imagen);
    texto = findViewById(R.id.textocomienzo);

        reload.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imagen.setImageResource(R.drawable.imagenreload);
                bala1.setEnabled(true);
                bala2.setEnabled(true);
                bala3.setEnabled(true);
                bala4.setEnabled(true);
                bala5.setEnabled(true);
                bala6.setEnabled(true);
                texto.setVisibility(View.INVISIBLE);
                bala1.setBackgroundResource(R.drawable.boton);
                bala2.setBackgroundResource(R.drawable.boton);
                bala3.setBackgroundResource(R.drawable.boton);
                bala4.setBackgroundResource(R.drawable.boton);
                bala5.setBackgroundResource(R.drawable.boton);
                bala6.setBackgroundResource(R.drawable.boton);

                final int random = (int)(Math.random() * 5);


                bala1.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        if (0 != random)
                        {
                            imagen.setImageResource(R.drawable.imagen1);
                            bala1.setEnabled(false);
                            bala1.setBackgroundResource(R.drawable.bala);
                        }
                        else
                        {
                            imagen.setImageResource(R.drawable.lose);
                            bala1.setEnabled(false);
                            bala2.setEnabled(false);
                            bala3.setEnabled(false);
                            bala4.setEnabled(false);
                            bala5.setEnabled(false);
                            bala6.setEnabled(false);
                            bala1.setBackgroundResource(R.drawable.bala);
                            bala2.setBackgroundResource(R.drawable.bala);
                            bala3.setBackgroundResource(R.drawable.bala);
                            bala4.setBackgroundResource(R.drawable.bala);
                            bala5.setBackgroundResource(R.drawable.bala);
                            bala6.setBackgroundResource(R.drawable.bala);
                            texto.setVisibility(View.VISIBLE);
                        }
                    }
                });

                bala2.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        if (1 != random)
                        {
                            imagen.setImageResource(R.drawable.imagen2);
                            bala2.setEnabled(false);
                            bala2.setBackgroundResource(R.drawable.bala);
                        }
                        else
                        {
                            imagen.setImageResource(R.drawable.lose);
                            bala1.setEnabled(false);
                            bala2.setEnabled(false);
                            bala3.setEnabled(false);
                            bala4.setEnabled(false);
                            bala5.setEnabled(false);
                            bala6.setEnabled(false);
                            bala1.setBackgroundResource(R.drawable.bala);
                            bala2.setBackgroundResource(R.drawable.bala);
                            bala3.setBackgroundResource(R.drawable.bala);
                            bala4.setBackgroundResource(R.drawable.bala);
                            bala5.setBackgroundResource(R.drawable.bala);
                            bala6.setBackgroundResource(R.drawable.bala);
                            texto.setVisibility(View.VISIBLE);
                        }
                    }
                });

                bala3.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        if (2 != random)
                        {
                            imagen.setImageResource(R.drawable.imagen3);
                            bala3.setEnabled(false);
                            bala3.setBackgroundResource(R.drawable.bala);
                        }
                        else
                        {
                            imagen.setImageResource(R.drawable.lose);
                            bala1.setEnabled(false);
                            bala2.setEnabled(false);
                            bala3.setEnabled(false);
                            bala4.setEnabled(false);
                            bala5.setEnabled(false);
                            bala6.setEnabled(false);
                            bala1.setBackgroundResource(R.drawable.bala);
                            bala2.setBackgroundResource(R.drawable.bala);
                            bala3.setBackgroundResource(R.drawable.bala);
                            bala4.setBackgroundResource(R.drawable.bala);
                            bala5.setBackgroundResource(R.drawable.bala);
                            bala6.setBackgroundResource(R.drawable.bala);
                            texto.setVisibility(View.VISIBLE);
                        }
                    }
                });

                bala4.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        if (3 != random)
                        {
                            imagen.setImageResource(R.drawable.imagen4);
                            bala4.setEnabled(false);
                            bala4.setBackgroundResource(R.drawable.bala);
                        }
                        else
                        {
                            imagen.setImageResource(R.drawable.lose);
                            bala1.setEnabled(false);
                            bala2.setEnabled(false);
                            bala3.setEnabled(false);
                            bala4.setEnabled(false);
                            bala5.setEnabled(false);
                            bala6.setEnabled(false);
                            bala1.setBackgroundResource(R.drawable.bala);
                            bala2.setBackgroundResource(R.drawable.bala);
                            bala3.setBackgroundResource(R.drawable.bala);
                            bala4.setBackgroundResource(R.drawable.bala);
                            bala5.setBackgroundResource(R.drawable.bala);
                            bala6.setBackgroundResource(R.drawable.bala);
                            texto.setVisibility(View.VISIBLE);
                        }
                    }
                });

                bala5.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        if (4 != random)
                        {
                            imagen.setImageResource(R.drawable.imagen5);
                            bala5.setEnabled(false);
                            bala5.setBackgroundResource(R.drawable.bala);
                        }
                        else
                        {
                            imagen.setImageResource(R.drawable.lose);
                            bala1.setEnabled(false);
                            bala2.setEnabled(false);
                            bala3.setEnabled(false);
                            bala4.setEnabled(false);
                            bala5.setEnabled(false);
                            bala6.setEnabled(false);
                            bala1.setBackgroundResource(R.drawable.bala);
                            bala2.setBackgroundResource(R.drawable.bala);
                            bala3.setBackgroundResource(R.drawable.bala);
                            bala4.setBackgroundResource(R.drawable.bala);
                            bala5.setBackgroundResource(R.drawable.bala);
                            bala6.setBackgroundResource(R.drawable.bala);
                            texto.setVisibility(View.VISIBLE);
                        }
                    }
                });

                bala6.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View v)
                    {

                        if (5 != random)
                        {
                            imagen.setImageResource(R.drawable.imagen1);
                            bala6.setEnabled(false);
                            bala6.setBackgroundResource(R.drawable.bala);
                        }
                        else
                        {
                            imagen.setImageResource(R.drawable.lose);
                            bala1.setEnabled(false);
                            bala2.setEnabled(false);
                            bala3.setEnabled(false);
                            bala4.setEnabled(false);
                            bala5.setEnabled(false);
                            bala6.setEnabled(false);
                            bala1.setBackgroundResource(R.drawable.bala);
                            bala2.setBackgroundResource(R.drawable.bala);
                            bala3.setBackgroundResource(R.drawable.bala);
                            bala4.setBackgroundResource(R.drawable.bala);
                            bala5.setBackgroundResource(R.drawable.bala);
                            bala6.setBackgroundResource(R.drawable.bala);
                            texto.setVisibility(View.VISIBLE);
                        }
                    }
                });
            }
        });


    }
}
