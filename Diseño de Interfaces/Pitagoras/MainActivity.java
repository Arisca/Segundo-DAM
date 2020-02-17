package com.example.ejerciciopitgoras;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private EditText cat1;
    private EditText cat2;
    private Button calcula;
    private TextView resultado;
    private Button nuevo;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cat1 = findViewById(R.id.editText);
        cat2 = findViewById(R.id.editText2);
        calcula = findViewById(R.id.button);
        resultado = findViewById(R.id.resultado);
        nuevo = findViewById(R.id.button2);

        calcula.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                double c1 = Integer.parseInt(cat1.getText().toString());
                double c2 = Integer.parseInt(cat2.getText().toString());

                double hipo = Math.hypot(c1, c2);

                resultado.setText("La hipotenusa exacta es : \n" + hipo);
            }
        });

        nuevo.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                cat1.setText("");
                cat2.setText("");
            }
        });
    }
}
