package com.example.elsol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    private GridView gridView;

    private String [] nombre = {"Corona Solar", "Erupción Solar", "Espiculas", "Filamentos", "Magnetosfera", "Mancha Solar"};

    private int [] imagen = {R.drawable.corona_solar, R.drawable.erupcionsolar, R.drawable.espiculas, R.drawable.filamentos, R.drawable.magnetosfera, R.drawable.manchasolar};

    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        gridView = findViewById(R.id.gridview);

        MainAdapter adapater = new MainAdapter (MainActivity.this, nombre, imagen);
        gridView.setAdapter(adapater);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick (AdapterView<?> parent, View view, int position, long id)
            {
                Toast.makeText(getApplicationContext(), "Has seleccionado "+nombre[+ position], Toast.LENGTH_SHORT).show();
            }
        });

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
        else if (menuopcion == R.id.action_info)
        {
            Intent intent = new Intent(MainActivity.this, informacion.class);
            MainActivity.this.startActivity(intent);
        }
        return super.onOptionsItemSelected (item);
    }
}
