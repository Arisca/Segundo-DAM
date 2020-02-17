package com.example.interfazbsica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class textviewandmore extends AppCompatActivity implements ViewSwitcher.ViewFactory
{

    Spinner spinner;
    TextView opcionelegida;
    ImageSwitcher imagegrande;
    ImageView imageandroid;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textviewandmore);

        spinner = findViewById(R.id.spinner);
        String[] opciones_spiner = new String[]{"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"};
        ArrayAdapter<String> adaptadorpinneropciones = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones_spiner);
        spinner.setAdapter(adaptadorpinneropciones);

        opcionelegida = findViewById(R.id.insertaropcion);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                opcionelegida.setText(parent.getItemAtPosition(position).toString());
            }

            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        imagegrande = findViewById(R.id.imagengrande);
        imageandroid = findViewById(R.id.imageView2);
        imagegrande.setFactory(this);
        imagegrande.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imagegrande.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));

        imageandroid.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imagegrande.setImageDrawable(imageandroid.getDrawable());
            }
        });
    }
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }

    public boolean onCreateOptionsMenu (Menu menu)
    {
        MenuInflater inflater = getMenuInflater(); inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item)
    {
        int menuopcion = item.getItemId();

        if (menuopcion == R.id.action_settings)
        {
            return true;
        }
        else if (menuopcion == R.id.action_search)
        {
            return true;
        }
        else if (menuopcion == R.id.action_add)
        {

        }
        return super.onOptionsItemSelected (item);
    }
}
