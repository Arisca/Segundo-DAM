package com.example.interfazbsica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class chipbuttonscrollview extends AppCompatActivity
{
    private ChipGroup cg;
    String option;
    Button acc;
    Button ave;
    Button dep;
    Button dis;
    Button est;
    Button luc;
    Button mus;
    Button rol;
    Button sim;
    FloatingActionButton fab;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chipbuttonscrollview);


        acc = findViewById(R.id.accion);
        acc.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
        {
                Toast.makeText(chipbuttonscrollview.this, "" + acc.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        ave = findViewById(R.id.aventura);
        ave.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + ave.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        dep = findViewById(R.id.deportes);
        dep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + dep.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        dis = findViewById(R.id.disparos);
        dis.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + dis.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        luc = findViewById(R.id.lucha);
        luc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + luc.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        est = findViewById(R.id.estrategia);
        est.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + est.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mus = findViewById(R.id.musical);
        mus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + mus.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        rol = findViewById(R.id.rol);
        rol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + rol.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        sim = findViewById(R.id.simulacion);
        sim.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(chipbuttonscrollview.this, "" + sim.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        cg = findViewById(R.id.chipGroup);
        cg.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(ChipGroup chipGroup, int i) {
                Chip chip = chipGroup.findViewById(i);
                if (chip != null) {
                    Toast.makeText(chipbuttonscrollview.this, chip.getText().toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view)
            {
                Snackbar.make (view, "El botón se desplaza hacia arriba", Snackbar.LENGTH_LONG).setAction ("Action", null).show();
            }
        });
    }
}

